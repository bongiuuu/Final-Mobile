package tdtu.mobile.todo;

import android.view.View;

import tdtu.mobile.todo.Base.BaseActivity;
import tdtu.mobile.todo.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void doBusiness() {
        binding.tvLogin.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}