package Classes;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class CrudPlaylist implements ICrudPlaylist {

    Database database;

    {
        try {
            database = new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Playlist createPlaylistRandomSongs(ArrayList<Song> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numarul de melodii din playlist");
        int numberOfSongs = sc.nextInt();
        System.out.println("Nume playlist:");
        String playlistName = sc.next();
        sc.nextLine();
        HashSet<Song> hashSet = new HashSet<Song>();
        Random random = new Random();
        while (hashSet.size() < numberOfSongs) {
            int randomIndex = random.nextInt(list.size());
            hashSet.add(list.get(randomIndex));

        }

        return new Playlist(playlistName, hashSet);

    }

    @Override
    public Playlist addSongsToPlaylistByArtistAndTitle() {
        HashSet<Song> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nume playlist: ");
        String playlistName = sc.next();
        System.out.println("Nume artist: ");
        String artistName = sc.next();
        sc.nextLine();
        System.out.println("Nume melodie: ");
        String songTitle = sc.next();

        Connection connection = database.connection;
        try {
            String query = "SELECT * FROM SONGS WHERE TITLE  = ? AND ARTIST = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, songTitle);
            statement.setString(2, artistName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                String link = resultSet.getString("link");
                int duration = resultSet.getInt("duration");
                Song song = new Song(title, Classes.genre.valueOf(genre), artist, link, duration);
                hashSet.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Playlist(playlistName, hashSet);

    }

    @Override
    public Playlist addAllTheSongFromAnArtist() {
        HashSet<Song> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nume playlist: ");
        String playlistName = sc.next();
        System.out.println("Nume artist: ");
        String artistName = sc.next();
        sc.nextLine();
        System.out.println("Nume melodie: ");
        String songTitle = sc.next();

        Connection connection = database.connection;
        try {
            String query = "SELECT * FROM SONGS WHERE ARTIST  = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, artistName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                String link = resultSet.getString("link");
                int duration = resultSet.getInt("duration");
                Song song = new Song(title, Classes.genre.valueOf(genre), artist, link, duration);
                hashSet.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Playlist(playlistName, hashSet);

    }

    @Override
    public void playPlaylist(Playlist playlist) throws URISyntaxException, IOException, InterruptedException {
        for (Song song : playlist.getSongList()) {
            String youtubeLink = song.getLink();
            Desktop.getDesktop().browse(new URI(youtubeLink));
            Thread.sleep(song.getDuration() * 1000L);
        }

    }


}
