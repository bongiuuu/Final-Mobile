package tdtu.mobile.todo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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

        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.miHome:
                        switchHome();
                        return true;

                    case R.id.miCalendar:
                        switchCalendar();
                        return true;

                    case R.id.miStatistic:
                        switchStatistic();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected View layoutId() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    public void switchHome() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment_activity_home, new HomeFragment()).commit();
    }

    public void switchCalendar() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment_activity_home, new CalendarFragment()).commit();
    }

    public void switchStatistic() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.nav_host_fragment_activity_home, new StatisticFragment()).commit();
    }
}