package Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Song {
    //    Variables
    private String title;
    private String genre;
    private String artist;
    private String link;
    private int duration;

    // CONSTRUCTOR

    public Song(String title, String genre, String artist, String link, int duration) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.duration = duration;
        this.link = link;
    }

    @Override
    public String toString() {
        return "\nSong : {" +
                "Title = '" + title + '\'' +
                ", Genre = " + genre +
                ", Artist = '" + artist + '\'' +
                ", Link = '" + link + '\'' +
                ", Duration = '" + duration + '\'' + " seconds" +
                "}";
    }

    public int getDuration() {
        return duration;
    }


    public String getLink() {
        return link;
    }

    public boolean ValidateTitle() {
        return this.title.contains(" ");
    }

    public boolean ValidateArtist() {
        return this.artist.length() >= 10;

    }
    public boolean ValidateDuration() {
        return this.duration > 0;

    }
    public boolean ValidateGenre() {
        try {
            for (genre gen : Classes.genre.values()) {
                if (gen.name().equals(this.genre)) {
                    return true;
                }
            }
            return false;
        }catch(Exception e){
           return false;
        }
    }

    public boolean ValidateLink() {
        Pattern youtubeLink = Pattern.compile("https?://(?:www\\.)?youtu(?:be\\.com/watch\\?v=|\\.be/)([\\w\\-_]*)(&(amp;)?\u200C\u200B[\\w?\u200C\u200B=]*)?");
        Matcher m = youtubeLink.matcher(this.link);
        return m.matches();
    }

    public boolean validateInput() {
        return ValidateTitle() && ValidateArtist() && ValidateLink() && ValidateGenre() && ValidateDuration();

    }

}



