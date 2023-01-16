package Classes;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface ICrudPlaylist {
    public void createPlaylistRandomSongs(ArrayList<Song> list, ArrayList<Playlist> allPlaylists);

    public void addSongsToPlaylistByArtistAndTitle(ArrayList<Playlist> allPlaylists);

    public void addAllTheSongFromAnArtist(ArrayList<Playlist> allPlaylists);

    public void seeAllPlaylists (ArrayList<Playlist> allPlaylists);

    public void playPlaylist (ArrayList<Playlist> allPlaylists) throws URISyntaxException, IOException, InterruptedException;


}

