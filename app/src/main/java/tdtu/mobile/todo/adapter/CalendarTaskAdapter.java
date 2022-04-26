package tdtu.mobile.todo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import tdtu.mobile.todo.R;
import tdtu.mobile.todo.model.CalendarTask;

public class CalendarTaskAdapter extends RecyclerView.Adapter<CalendarTaskAdapter.ViewHolder> {

    private final CalendarTask[] calendarTasks;

    public CalendarTaskAdapter(CalendarTask[] calendarTasks) {
        this.calendarTasks = calendarTasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_task_calendar, parent, false);
        CalendarTaskAdapter.ViewHolder viewHolder = new CalendarTaskAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CalendarTask calendarTask = calendarTasks[position];

        if (position == 0) {
            holder.vLine1.setVisibility(View.INVISIBLE);
        } else if (position == calendarTasks.length - 1) {
            holder.vLine2.setVisibility(View.INVISIBLE);
        }

        if (calendarTask.getStatus() == 0){
            holder.tvStatus.setText("In progress");
        } else {
            holder.tvStatus.setText("Done");
        }

        holder.tvTaskTitle.setText(calendarTask.getTaskTitle());
        holder.tvTime.setText(calendarTask.getTime());

        switch (calendarTask.getPriority()) {
            case 1:
                holder.ivPriority.setImageResource(R.drawable.alert1);
                break;
            case 2:
                holder.ivPriority.setImageResource(R.drawable.alert2);
                break;
            case 3:
                holder.ivPriority.setImageResource(R.drawable.alert3);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return calendarTasks.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStatus;
        public TextView tvTaskTitle;
        public TextView tvTime;
        public ImageView ivPriority;
        public CardView cvTask;
        public View vLine1;
        public View vLine2;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvStatus = itemView.findViewById(R.id.tvStatus);
            this.tvTaskTitle = itemView.findViewById(R.id.tvTaskTitle);
            this.tvTime = itemView.findViewById(R.id.tvTime);
            this.ivPriority = itemView.findViewById(R.id.ivPriority);
            this.cvTask = itemView.findViewById(R.id.cvTask);
            this.vLine1 = itemView.findViewById(R.id.vLine1);
            this.vLine2 = itemView.findViewById(R.id.vLine2);
        }
    }
}
