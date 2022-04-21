package tdtu.mobile.todo;

import android.content.Intent;
import android.view.View;

import tdtu.mobile.todo.databinding.ActivityOtpVerificationBinding;

public class OtpVerificationActivity extends BaseActivity {

    ActivityOtpVerificationBinding binding;

    @Override
    protected void doBusiness() {
        binding.cvBack.setOnClickListener(v -> {
            onBackPressed();
        });

        binding.btnSubmit.setOnClickListener(v -> {
            Intent resetPasswordIntent = new Intent(this, ResetPasswordActivity.class);
            startActivity(resetPasswordIntent);
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityOtpVerificationBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}