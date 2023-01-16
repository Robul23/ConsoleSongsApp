package Classes;

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
        return "\n Playlist{" +
                "Playlist name = '" + playlistName + '\'' +
                ",\n songList = " + songList +
                '}';
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public HashSet<Song> getSongList() {
        return songList;
    }


}








