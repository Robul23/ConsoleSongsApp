package Classes;

import java.util.ArrayList;
import java.util.HashSet;

public class Playlist {
    private String playlistName;
    private HashSet<Song> songList;

    public Playlist(String playlistName, HashSet<Song> songList) {
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

    public HashSet<Song> getSongList() {
        return songList;
    }

    public void setSongList(HashSet<Song> songList) {
        this.songList = songList;
    }
}








