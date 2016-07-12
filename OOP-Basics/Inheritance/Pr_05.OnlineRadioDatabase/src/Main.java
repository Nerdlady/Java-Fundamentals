import excaptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesNumber = Integer.parseInt(reader.readLine());
        Playlist playlist = new Playlist();
        for (int i = 0; i < linesNumber; i++) {
            String[] info = reader.readLine().split(";");
            String artist = info[0];
            String songName = info[1];
            String[] time = info[2].split(":");

            String munuters = time[0];
            String seconds = time[1];


            try {
                Song song = new Song(artist, songName, munuters, seconds);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.printf("Songs added: %d%n", playlist.getSongsCount());
        System.out.printf("Playlist length: %s%n", playlist.getPlaylistTime());

    }
}
