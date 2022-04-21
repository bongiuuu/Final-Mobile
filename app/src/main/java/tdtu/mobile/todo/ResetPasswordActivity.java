
package tdtu.mobile.todo;

import android.view.View;

import tdtu.mobile.todo.databinding.ActivityResetPasswordBinding;

public class ResetPasswordActivity extends BaseActivity {

    ActivityResetPasswordBinding binding;

    @Override
    protected void doBusiness() {
        binding.cvBack.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}