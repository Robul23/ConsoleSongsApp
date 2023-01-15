package Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song {

    //    Variables

    private String title;
    private genre genre;
    private String artist;
    private String link;

    private int duration;

    // CONSTRUCTOR

    public Song(String title, Classes.genre genre, String artist, String link, int duration) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", artist='" + artist + '\'' +
                ", link='" + link + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Classes.genre getGenre() {
        return genre;
    }

    public void setGenre(Classes.genre genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public boolean ValidateTitle() {
        return this.title.contains(" ");
    }

    public boolean ValidateArtist() {
        return this.artist.length() >= 10;

    }

    public boolean ValidateDudartion() {
        return this.duration > 0;

    }

    public boolean ValidateGenre() {
        for (genre gen : Classes.genre.values()) {
            if (gen.name().equals(this.genre.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean ValidateLink() {
        Pattern youtubeLink = Pattern.compile("https?://(?:www\\.)?youtu(?:be\\.com/watch\\?v=|\\.be/)([\\w\\-_]*)(&(amp;)?\u200C\u200B[\\w?\u200C\u200B=]*)?");
        Matcher m = youtubeLink.matcher(this.link);
        return m.matches();
    }

    public boolean validateInput() {
        return ValidateTitle() && ValidateArtist() && ValidateLink() && ValidateGenre() && ValidateDudartion();

    }

}



