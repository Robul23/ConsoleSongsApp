import Classes.CrudSongs;
import java.sql.*;


public class Main {





    public static void main(String[] args) throws SQLException {

        CrudSongs crud = new CrudSongs();
        crud.addSong();
        crud.deleteSong();
        crud.seeAll();

    }


}