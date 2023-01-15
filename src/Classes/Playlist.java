package Classes;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    private ArrayList<Song> songList;

    public Playlist(String playlistName, ArrayList<Song> songList) {
        this.playlistName = playlistName;
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", songList=" + songList +
                '}';
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }
}








