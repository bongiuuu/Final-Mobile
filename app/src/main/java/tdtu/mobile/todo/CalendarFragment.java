package tdtu.mobile.todo;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import tdtu.mobile.todo.adapter.CalendarTaskAdapter;
import tdtu.mobile.todo.adapter.TaskAdapter;
import tdtu.mobile.todo.model.CalendarTask;
import tdtu.mobile.todo.model.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private TextView tvDay;
    private TextView tvWeek;
    private TextView tvMonth;
    private TextView tvYear;
    private TextView selectDay;
    private TextView selectWeek;
    private TextView selectMonth;
    private TextView selectYear;
    private TextView tvNumTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        String blue = "#60acef";

        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        tvDay = view.findViewById(R.id.tvDay);
        tvWeek = view.findViewById(R.id.tvWeek);
        tvMonth = view.findViewById(R.id.tvMonth);
        tvYear = view.findViewById(R.id.tvYear);
        selectDay = view.findViewById(R.id.selectDay);
        selectWeek = view.findViewById(R.id.selectWeek);
        selectMonth = view.findViewById(R.id.selectMonth);
        selectYear = view.findViewById(R.id.selectYear);
        tvNumTask = view.findViewById(R.id.tvNumTask);

        CalendarTask[] calendarTasksDay = new CalendarTask[] {
                new CalendarTask(1, "Calendar Task Day 1", "7:00", 1),
                new CalendarTask(0, "Calendar Task Day 2", "10:30", 2),
                new CalendarTask(0, "Calendar Task Day 3", "11:00", 1),
                new CalendarTask(0, "Calendar Task Day 4", "15:30", 3),
        };

        CalendarTask[] calendarTasksWeek = new CalendarTask[] {
                new CalendarTask(1, "Calendar Task Week 1", "7:00", 1),
                new CalendarTask(0, "Calendar Task Week 2", "10:30", 2),
                new CalendarTask(0, "Calendar Task Week 3", "11:00", 1),
                new CalendarTask(0, "Calendar Task Week 4", "15:30", 3),
                new CalendarTask(0, "Calendar Task Week 5", "16:30", 3),
        };

        CalendarTask[] calendarTasksMonth = new CalendarTask[] {
                new CalendarTask(1, "Calendar Task Month 1", "7:00", 1),
                new CalendarTask(0, "Calendar Task Month 2", "10:30", 2),
                new CalendarTask(0, "Calendar Task Month 3", "11:00", 1),
                new CalendarTask(0, "Calendar Task Month 4", "15:30", 3),
                new CalendarTask(0, "Calendar Task Month 5", "16:30", 3),
                new CalendarTask(0, "Calendar Task Month 6", "17:30", 3),
        };

        CalendarTask[] calendarTasksYear = new CalendarTask[] {
                new CalendarTask(1, "Calendar Task Year 1", "7:00", 1),
                new CalendarTask(0, "Calendar Task Year 2", "10:30", 2),
                new CalendarTask(0, "Calendar Task Year 3", "11:00", 1),
                new CalendarTask(0, "Calendar Task Year 4", "15:30", 3),
                new CalendarTask(0, "Calendar Task Year 5", "16:30", 3),
                new CalendarTask(0, "Calendar Task Year 6", "17:30", 3),
                new CalendarTask(0, "Calendar Task Year 7", "18:30", 3),
        };


        RecyclerView rvTask = view.findViewById(R.id.rvCalendarTask);
        CalendarTaskAdapter calendarTaskAdapter = new CalendarTaskAdapter(calendarTasksDay);
        rvTask.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvTask.setAdapter(calendarTaskAdapter);

        tvDay.setOnClickListener(v -> {
            setTextBackgroundColor(tvDay, tvWeek, tvMonth, tvYear, selectDay, selectWeek, selectMonth, selectYear,
                    tvNumTask, calendarTasksDay, rvTask, 1);
        });

        tvWeek.setOnClickListener(v -> {
            setTextBackgroundColor(tvWeek, tvDay, tvMonth, tvYear, selectWeek, selectDay, selectMonth, selectYear,
                    tvNumTask, calendarTasksWeek, rvTask, 2);
        });

        tvMonth.setOnClickListener(v -> {
            setTextBackgroundColor(tvMonth, tvDay, tvWeek, tvYear, selectMonth, selectDay, selectWeek, selectYear,
                    tvNumTask, calendarTasksMonth, rvTask, 3);
        });

        tvYear.setOnClickListener(v -> {
            setTextBackgroundColor(tvYear, tvDay, tvWeek, tvMonth, selectYear, selectDay, selectWeek, selectMonth,
                    tvNumTask, calendarTasksYear, rvTask, 4);
        });

        tvNumTask.setText(Integer.toString(calendarTasksDay.length).concat(" tasks today"));

        return view;
    }

    private void setTextBackgroundColor(TextView tvBlue, TextView tvWhite1, TextView tvWhite2, TextView tvWhite3,
                                        TextView tvWhiteBG, TextView tvBlueBG1, TextView tvBlueBG2, TextView tvBlueBG3,
                                        TextView tvNumberOfTask, CalendarTask[] calendarTasks_, RecyclerView recyclerView, int id){
        String blue = "#60acef";

        tvBlue.setTextColor(Color.parseColor(blue));
        tvWhite1.setTextColor(Color.WHITE);
        tvWhite2.setTextColor(Color.WHITE);
        tvWhite3.setTextColor(Color.WHITE);

        tvWhiteBG.setBackgroundResource(R.drawable.track);
        tvBlueBG1.setBackgroundResource(android.R.color.transparent);
        tvBlueBG2.setBackgroundResource(android.R.color.transparent);
        tvBlueBG3.setBackgroundResource(android.R.color.transparent);

        switch (id) {
            case 1:
                displayNumberOfTask(calendarTasks_, tvNumberOfTask, "today");
                break;
            case 2:
                displayNumberOfTask(calendarTasks_, tvNumberOfTask, "this week");
                break;
            case 3:
                displayNumberOfTask(calendarTasks_, tvNumberOfTask, "this month");
                break;
            case 4:
                displayNumberOfTask(calendarTasks_, tvNumberOfTask, "this year");
                break;
        }

        recyclerView.setAdapter(new CalendarTaskAdapter(calendarTasks_));
    }

    @SuppressLint("SetTextI18n")
    private void displayNumberOfTask(CalendarTask[] calendarTask_, TextView tvNumOfTask, String period){
        if (calendarTask_.length == 1){
            tvNumOfTask.setText(Integer.toString(calendarTask_.length).concat(" task ").concat(period));
        } else {
            tvNumOfTask.setText(Integer.toString(calendarTask_.length).concat(" tasks ").concat(period));
        }
    }
}