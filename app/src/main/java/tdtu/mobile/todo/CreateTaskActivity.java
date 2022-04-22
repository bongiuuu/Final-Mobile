package tdtu.mobile.todo;

import android.content.Intent;
import android.view.View;

import tdtu.mobile.todo.Base.BaseActivity;
import tdtu.mobile.todo.databinding.ActivityCreateTaskBinding;

public class CreateTaskActivity extends BaseActivity {

    ActivityCreateTaskBinding binding;

    @Override
    protected void doBusiness() {
        binding.btnNextStep.setOnClickListener(v -> {
            Intent createTaskContIntent = new Intent(this, CreateTaskContinueActivity.class);
            startActivity(createTaskContIntent);
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityCreateTaskBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}