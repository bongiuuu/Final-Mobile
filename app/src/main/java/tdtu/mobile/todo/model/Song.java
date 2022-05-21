package tdtu.mobile.todo.model;

public class Song {
    private String songName;
    private String singer;
    private int image;

    public Song(String songName, String singer, int image) {
        this.songName = songName;
        this.singer = singer;
        this.image = image;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
