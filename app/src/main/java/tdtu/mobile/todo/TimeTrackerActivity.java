package tdtu.mobile.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import tdtu.mobile.todo.Base.BaseActivity;
import tdtu.mobile.todo.adapter.PreviousTaskAdapter;
import tdtu.mobile.todo.adapter.TaskAdapter;
import tdtu.mobile.todo.databinding.ActivityTimeTrackerBinding;
import tdtu.mobile.todo.model.PreviousTask;
import tdtu.mobile.todo.model.Task;

public class TimeTrackerActivity extends BaseActivity {

    ActivityTimeTrackerBinding binding;

    @Override
    protected void doBusiness() {

        binding.btnBack.setOnClickListener(v -> {
            onBackPressed();
        });

        PreviousTask[] previousTasks = new PreviousTask[]{
                new PreviousTask(1, "Create a new project", "00:01:15:40"),
                new PreviousTask(0, "Study English", "00:00:30:00"),
                new PreviousTask(0, "Set the PC", "00:01:15:40"),
                new PreviousTask(0, "Create a new project", "00:01:15:40"),
        };

        RecyclerView rvTask = binding.rvPreviousTask;
        PreviousTaskAdapter previousTaskAdapter = new PreviousTaskAdapter(previousTasks);
        rvTask.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvTask.setAdapter(previousTaskAdapter);
    }

    @Override
    protected View layoutId() {
        binding = ActivityTimeTrackerBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}