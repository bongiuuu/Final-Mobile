package tdtu.mobile.todo;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tdtu.mobile.todo.Base.BaseActivity;
import tdtu.mobile.todo.adapter.PreviousTaskAdapter;
import tdtu.mobile.todo.databinding.ActivityTimeTrackerBinding;
import tdtu.mobile.todo.model.PreviousTask;

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

        startTimer(4.8);
    }

    @Override
    protected View layoutId() {
        binding = ActivityTimeTrackerBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    private void startTimer(final double minute) {
        CountDownTimer countDownTimer = new CountDownTimer((long) (60L * minute * 1000), 500) {
            // 500 means, onTick function will be called at every 500 milliseconds

            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;
                long d = seconds/86400;
                long h = (seconds - d*86400)/3600;
                long m = (seconds - d*86400 - h*3600)/60;

                int pbMax = (int) (minute*60);
                binding.pbTime.setMax(pbMax);
                int pbTimer = (int) (pbMax - (d*86400 + h*3600 + m*60 + seconds%60));
                binding.pbTime.setProgress(pbTimer);

                String day = String.format("%02d", d);
                String hour = String.format("%02d", h);
                String minute = String.format("%02d", m);
                String second = (String.format("%02d", seconds%60));

                binding.tvTime.setText(day.concat(":").
                                concat(hour).concat(":").
                                concat(minute).concat(":").
                                concat(second));

                // format the textview to show the easily readable format

            }
            @Override
            public void onFinish() {
//                if(binding.tvTime.getText().equals("00:00:00:00")){
//                    binding.tvTime.setText("STOP");
//                }
            }
        }.start();

    }
}