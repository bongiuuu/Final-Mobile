package tdtu.mobile.todo;

import android.content.Intent;
import android.view.View;

import tdtu.mobile.todo.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends BaseActivity {

    ActivityForgotPasswordBinding binding;

    @Override
    protected void doBusiness() {
        binding.cvBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.btnGetOtp.setOnClickListener(v -> {
            Intent getOtpIntent = new Intent(this, OtpVerificationActivity.class);
            startActivity(getOtpIntent);
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}