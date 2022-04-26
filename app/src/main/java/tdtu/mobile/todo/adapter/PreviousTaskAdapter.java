package tdtu.mobile.todo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import tdtu.mobile.todo.R;
import tdtu.mobile.todo.model.PreviousTask;

public class PreviousTaskAdapter extends RecyclerView.Adapter<PreviousTaskAdapter.ViewHolder> {

    private PreviousTask[] previousTasks;

    public PreviousTaskAdapter(PreviousTask[] previousTasks) {
        this.previousTasks = previousTasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_previous_task_layout, parent, false);
        PreviousTaskAdapter.ViewHolder viewHolder = new PreviousTaskAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PreviousTask previousTask = previousTasks[position];

        if (previousTask.getStatus() == 0){
            holder.tvStatus.setText("In progress");
        } else {
            holder.tvStatus.setText("Done");
        }

        holder.tvTaskTitle.setText(previousTask.getTaskTitle());
        holder.tvTime.setText(previousTask.getTime());
    }

    @Override
    public int getItemCount() {
        return previousTasks.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStatus;
        public TextView tvTaskTitle;
        public TextView tvTime;
        public CardView cvTask;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvStatus = itemView.findViewById(R.id.tvStatus);
            this.tvTaskTitle = itemView.findViewById(R.id.tvTaskTitle);
            this.tvTime = itemView.findViewById(R.id.tvTime);
            this.cvTask = itemView.findViewById(R.id.cvTask);
        }
    }
}
