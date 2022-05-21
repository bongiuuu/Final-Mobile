package tdtu.mobile.todo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import tdtu.mobile.todo.adapter.SongAdapter;
import tdtu.mobile.todo.adapter.TaskAdapter;
import tdtu.mobile.todo.model.Song;
import tdtu.mobile.todo.model.Task;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_music, container, false);

        TextView tvAddSong = rootView.findViewById(R.id.tvAddSong);
        ImageView ivMusic = rootView.findViewById(R.id.ivMusic);
        FlexboxLayout fbMusic = rootView.findViewById(R.id.fbMusic);
        RecyclerView rvMusic = rootView.findViewById(R.id.rvMusic);

        ivMusic.setOnClickListener(v -> {
            fbMusic.setVisibility(View.VISIBLE);
            rvMusic.setVisibility(View.VISIBLE);
        });

        Song[] songs = new Song[]{
                new Song("24K Magic", "Bruno Mars", R.drawable.bg_music),
                new Song("Man of the Woods", "Justin Timberlake", R.drawable.bg_music),
                new Song("Blank Space", "Taylor Swift", R.drawable.bg_music),
                new Song("The way I still love you", "Reynard Silva", R.drawable.bg_music)
        };

        SongAdapter songAdapter = new SongAdapter(songs);
        rvMusic.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rvMusic.setAdapter(songAdapter);

        return rootView;
    }
}