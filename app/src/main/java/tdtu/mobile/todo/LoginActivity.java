package tdtu.mobile.todo;

import android.content.Intent;
import android.view.View;

import tdtu.mobile.todo.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void doBusiness() {
        binding.tvCreateAccount.setOnClickListener(v -> {
            Intent signUpIntent = new Intent(this, SignUpActivity.class);
            startActivity(signUpIntent);
        });

        binding.tvForgotPassword.setOnClickListener(v -> {
            Intent forgotPasswordIntent = new Intent(this, ForgotPasswordActivity.class);
            startActivity(forgotPasswordIntent);
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}