package tdtu.mobile.todo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import tdtu.mobile.todo.R;
import tdtu.mobile.todo.model.Category;
import tdtu.mobile.todo.model.Task;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private Task[] tasks;

    public TaskAdapter(Task[] tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_task_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Task task = tasks[position];

        if (task.getStatus() == 0){
            holder.tvStatus.setText("In progress");
        } else {
            holder.tvStatus.setText("Done");
        }

        holder.tvTaskTitle.setText(task.getTaskTitle());


        if (task.getPriority() == 1) {
            holder.ivPriority.setImageResource(R.drawable.alert1);
        } else if (task.getPriority() == 2) {
            holder.ivPriority.setImageResource(R.drawable.alert2);
        } else {
            holder.ivPriority.setImageResource(R.drawable.alert3);
        }

        if (task.getPercent() > 0) {
            holder.tvPercent.setText(Integer.toString(task.getPercent()).concat("%"));
            holder.pbTask.setProgress(task.getPercent());
        } else {
            holder.tvPercent.setVisibility(View.INVISIBLE);
            holder.tvPercent.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return tasks.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStatus;
        public TextView tvTaskTitle;
        public TextView tvPercent;
        public ImageView ivPriority;
        public CardView cvTask;
        public RoundCornerProgressBar pbTask;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvStatus = itemView.findViewById(R.id.tvStatus);
            this.tvTaskTitle = itemView.findViewById(R.id.tvTaskTitle);
            this.tvPercent = itemView.findViewById(R.id.tvPercent);
            this.ivPriority = itemView.findViewById(R.id.ivPriority);
            this.cvTask = itemView.findViewById(R.id.cvTask);
            this.pbTask = itemView.findViewById(R.id.pbTask);
        }
    }
}
