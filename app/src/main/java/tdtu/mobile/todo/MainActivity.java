package tdtu.mobile.todo;

import android.content.Intent;
import android.view.View;

import tdtu.mobile.todo.Base.BaseActivity;
import tdtu.mobile.todo.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void doBusiness() {
        binding.bottomNavigationView.setBackground(null);

        binding.btnCreateTask.setOnClickListener(v -> {
            Intent createTaskIntent = new Intent(this, CreateTaskActivity.class);
            startActivity(createTaskIntent);
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}