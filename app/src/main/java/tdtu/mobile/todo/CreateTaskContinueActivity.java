package tdtu.mobile.todo;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

import tdtu.mobile.todo.Base.BaseActivity;
import tdtu.mobile.todo.databinding.ActivityCreateTaskContinueBinding;

public class CreateTaskContinueActivity extends BaseActivity {

    ActivityCreateTaskContinueBinding binding;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void doBusiness() {
        binding.ivDate.setOnClickListener(v -> {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "datePicker");
            binding.tvDate.setText("ok");
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityCreateTaskContinueBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
//            btnDate.setText(ConverterDate.ConvertDate(year, month + 1, day));
        }
    }
}