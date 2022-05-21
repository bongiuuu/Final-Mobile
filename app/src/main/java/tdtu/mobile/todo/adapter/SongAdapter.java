package tdtu.mobile.todo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import tdtu.mobile.todo.R;
import tdtu.mobile.todo.model.Song;
import tdtu.mobile.todo.model.Task;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private Song[] songs;

    public SongAdapter(Song[] songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_songs_layout, parent, false);
        SongAdapter.ViewHolder viewHolder = new SongAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Song song = songs[position];

        holder.tvSongName.setText(song.getSongName());
        holder.tvArtistName.setText(song.getSinger());
        holder.ivSongPic.setImageResource(song.getImage());
    }

    @Override
    public int getItemCount() {
        return songs.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvSongName;
        public TextView tvArtistName;
        public ImageView ivSongPic;
        public ImageView ivDelete;
        public CardView cvSong;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvSongName = itemView.findViewById(R.id.tvSongName);
            this.tvArtistName = itemView.findViewById(R.id.tvArtistName);
            this.ivSongPic = itemView.findViewById(R.id.ivSongPic);
            this.ivDelete = itemView.findViewById(R.id.ivDelete);
            this.cvSong = itemView.findViewById(R.id.cvSong);
        }
    }
}
