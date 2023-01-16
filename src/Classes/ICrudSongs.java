package Classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface ICrudSongs {
    public void addSong();
    public void deleteSong();
    public void seeAll();

    public void storeAllSongsInArray(ArrayList<Song> songList);

}
