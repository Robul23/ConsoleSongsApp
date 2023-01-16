package Classes;

import java.util.ArrayList;

public interface ICrudPlaylist {
    void createPlaylistRandomSongs(ArrayList<Song> list, ArrayList<Playlist> allPlaylists);

    void addSongsToPlaylistByArtistAndTitle(ArrayList<Playlist> allPlaylists);

    void addAllTheSongFromAnArtist(ArrayList<Playlist> allPlaylists);

    void seeAllPlaylists(ArrayList<Playlist> allPlaylists);

    Thread playPlaylist(ArrayList<Playlist> allPlaylists, String playedPlaylistName);

    Playlist checkPlaylistName(ArrayList<Playlist> allPlaylists , String nameToBeChecked);
}
