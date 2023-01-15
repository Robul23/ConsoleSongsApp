package Classes;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface ICrudPlaylist {
    public Playlist createPlaylistRandomSongs(ArrayList<Song> list);

    public Playlist addSongsToPlaylistByArtistAndTitle();

    public Playlist addAllTheSongFromAnArtist();

    public void playPlaylist (Playlist playlist) throws URISyntaxException, IOException, InterruptedException;


}

