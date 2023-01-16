package Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrudSong implements ICrudSong {

    Database database;
    {
        try {
            database = new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addSong() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add a valid title(at least 2 words) ");
        String title = sc.nextLine();
        System.out.println("Add a valid gen(rock, pop, jazz, hiphop, electronic): ");
        String gen = sc.next();
        System.out.println("Add a valid artist(10 characters): ");
        String artist = sc.next();
        System.out.println("Add a valid youtube link: ");
        String link = sc.next();
        System.out.println("Add a valid duration(not negative): ");
        int duration = sc.nextInt();

        Song song = new Song(title, gen, artist, link, duration);
        if (song.validateInput()) {
            Connection connection = database.connection;
            try {
                String query = "INSERT INTO SONGS(title, genre, artist, link, duration) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, title);
                statement.setString(2, String.valueOf(gen));
                statement.setString(3, artist);
                statement.setString(4, link);
                statement.setInt(5, duration);
                statement.execute();
                System.out.println("Song added to database!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Not a valid song");
        }
    }

    public void deleteSong() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Title of the song you want to delete: ");
        String title = sc.nextLine();
        Connection connection = database.connection;
        try {
            String query = "DELETE FROM songs where title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.execute();
            System.out.println("Song deleted from database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    //see all songs sorted by duration
    public void seeAll() {
        Connection connection = database.connection;
        try {
            String query = "SELECT * FROM SONGS ORDER BY DURATION";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("All songs from the database:");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                String link = resultSet.getString("link");
                int duration = resultSet.getInt("duration");
                Song song = new Song(title, genre, artist, link, duration);
                System.out.println(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void storeAllSongsInArray(ArrayList<Song> songList){
        Connection connection = database.connection;
        try {
            String query = "SELECT * FROM SONGS ORDER BY DURATION";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                String link = resultSet.getString("link");
                int duration = resultSet.getInt("duration");
                Song song = new Song(title, genre, artist, link, duration);
                songList.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}



