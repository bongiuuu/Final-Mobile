package tdtu.mobile.todo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tdtu.mobile.todo.adapter.CategoryAdapter;
import tdtu.mobile.todo.adapter.TaskAdapter;
import tdtu.mobile.todo.model.Category;
import tdtu.mobile.todo.model.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Category[] categories = new Category[]{
                new Category("Work", 1, "#60acef"),
                new Category("Home", 3, "#ee6d3e"),
                new Category("Study", 2, "#5e67ec"),
                new Category("Activities", 1, "#FF03DAC5"),
        };

        RecyclerView rvCategory = rootView.findViewById(R.id.rvCategory);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvCategory.setAdapter(categoryAdapter);

        Task[] tasks = new Task[]{
                new Task(1, "Create a new project", 1, 100),
                new Task(0, "Go to a shop", 3, 73),
                new Task(0, "Create a new project", 2, 0),
                new Task(0, "Create a new project", 1, 0),
        };

        RecyclerView rvTask = rootView.findViewById(R.id.rvTask);
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        rvTask.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvTask.setAdapter(taskAdapter);

        return rootView;
    }
}