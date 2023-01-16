package Classes;

import java.util.ArrayList;

public interface ICrudSong {

    void addSong();

    void deleteSong();

    void seeAll();

    void storeAllSongsInArray(ArrayList<Song> songList);
}
