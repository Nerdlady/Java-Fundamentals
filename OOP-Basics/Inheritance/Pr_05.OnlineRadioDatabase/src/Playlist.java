import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;
    private int allSeconds;
    private int allMinutes;

    public Playlist() {
        this.songs = new ArrayList<>();
        this.allSeconds = 0;
        this.allMinutes = 0;
    }

    public void addSong(Song song) {
        this.songs.add(song);
        this.allSeconds += song.getSeconds();
        this.allMinutes += song.getMinutes();
    }

    public int getSongsCount(){
        return this.songs.size();
    }

    public String getPlaylistTime() {
        long totalLength = (this.allMinutes * 60) + this.allSeconds;
        long hours = totalLength / 60 / 60;
        long minutes = (totalLength / 60) - (hours * 60);
        long seconds = totalLength % 60;
        return String.format("%dh %dm %ds",hours,minutes,seconds);
    }

}
