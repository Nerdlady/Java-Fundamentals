import excaptions.*;

public class Song {
    private String author;
    private String name;
    private int minutes;
    private int seconds;

    public Song(String author, String name, String minutes, String seconds) throws InvalidSongException {
      this.setAuthor(author);
        this.setName(name);
        checkLenght(minutes,seconds);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws InvalidArtistNameException {
        if (author.length() < 3 || author.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.author = author;
    }

        public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidSongNameException {
        if (name.length() < 3 || name.length() > 30){
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }
        this.name = name;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) throws InvalidSongMinutesException {
        int mins = Integer.parseInt(minutes);
        if (mins < 0 || mins > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = mins;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) throws InvalidSongSecondsException {

        int sec = Integer.parseInt(seconds);
        if (sec < 0 || sec > 59)
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        this.seconds = sec;
    }

    private void checkLenght(String minutes,String seconds) throws InvalidSongLengthException {
        try {
            int mins = Integer.parseInt(minutes);
            int sec = Integer.parseInt(seconds);
        } catch (NumberFormatException e){
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }
}
