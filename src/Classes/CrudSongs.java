package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudSongs implements ICrudSongs {

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
        System.out.println("Add a valid title: ");
        String title = sc.nextLine();
        System.out.println("Add a valid gen: ");
        genre gen = genre.valueOf(sc.next());
        System.out.println("Add a valid artist: ");
        String artist = sc.next();
        sc.nextLine();
        System.out.println("Add a valid link: ");
        String link = sc.next();
        System.out.println("Add a valid duration: ");
        int duration = sc.nextInt();
        sc.close();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Not a valid song");
        }
    }

    public void deleteSong() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu titlul cantecului pe care vrei sa il stergi: ");
        String title = sc.nextLine();
        Connection connection = database.connection;
        try {
            String query = "DELETE FROM songs where title = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, title);
            statement.execute();
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
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                String link = resultSet.getString("link");
                int duration = resultSet.getInt("duration");
                Song song = new Song(title, Classes.genre.valueOf(genre), artist, link, duration);
                System.out.println(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



