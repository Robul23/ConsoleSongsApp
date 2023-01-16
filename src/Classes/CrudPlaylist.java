package Classes;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


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
    public void createPlaylistRandomSongs(ArrayList<Song> list, ArrayList<Playlist> allPlaylists) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Playlist name:");
        String playlistName = sc.nextLine();
        if (checkPlaylistName(allPlaylists, playlistName) != null) {
            System.out.println("There is already a playlist with this name. Please chose another name!");
            return;
        }
        System.out.println("Number of songs: ");
        int numberOfSongs = sc.nextInt();
        HashSet<Song> hashSet = new HashSet<>();
        Random random = new Random();
        while (hashSet.size() < numberOfSongs) {
            int randomIndex = random.nextInt(list.size());
            hashSet.add(list.get(randomIndex));

        }

        Playlist playlist = new Playlist(playlistName, hashSet);
        allPlaylists.add(playlist);
        System.out.println("Playlist created successfully!");
        System.out.println(playlist);

    }

    @Override
    public void addSongsToPlaylistByArtistAndTitle(ArrayList<Playlist> allPlaylists) {
        HashSet<Song> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Playlist name: ");
        String playlistName = sc.nextLine();
        System.out.println("Artist name: ");
        String artistName = sc.nextLine();
        System.out.println("Song name: ");
        String songTitle = sc.nextLine();
        System.out.println("Nume : " + artistName);
        System.out.println("Song : " + songTitle);

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
                Song song = new Song(title, genre, artist, link, duration);
                hashSet.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (checkPlaylistName(allPlaylists, playlistName) != null) {

            System.out.println("Song added to an existing playlist!");
            Playlist playlist = checkPlaylistName(allPlaylists, playlistName);
            playlist.getSongList().addAll(hashSet);
            System.out.println(playlist);
        } else {
            Playlist playlist = new Playlist(playlistName, hashSet);
            allPlaylists.add(playlist);
            System.out.println("Playlist created successfully!");
            System.out.println(playlist);
        }


    }

    @Override
    public void addAllTheSongFromAnArtist(ArrayList<Playlist> allPlaylists) {
        HashSet<Song> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Playlist name: ");
        String playlistName = sc.nextLine();
        System.out.println("Artist name: ");
        String artistName = sc.nextLine();


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
                Song song = new Song(title, genre, artist, link, duration);
                hashSet.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (checkPlaylistName(allPlaylists, playlistName) != null) {

            System.out.println("Song added to an existing playlist!");
            Playlist playlist = checkPlaylistName(allPlaylists, playlistName);
            playlist.getSongList().addAll(hashSet);
            System.out.println(playlist);
        } else {
            Playlist playlist = new Playlist(playlistName, hashSet);
            allPlaylists.add(playlist);
            System.out.println("Playlist created successfully!");
            System.out.println(playlist);
        }


    }

    @Override
    public void seeAllPlaylists(ArrayList<Playlist> allPlaylists) {
        System.out.println("Here is a list with all playlists that you created: ");
        for (Playlist playlist : allPlaylists) {
            System.out.println(playlist.toString());

        }
    }

    @Override
    public Thread playPlaylist(ArrayList<Playlist> allPlaylists, String playedPlaylistName) {
        return new Thread(() -> {
            try {
                boolean playlistFound = false;
                for (Playlist playlist : allPlaylists) {
                    if (Objects.equals(playlist.getPlaylistName(), playedPlaylistName)) {
                        playlistFound = true;
                        for (Song song : playlist.getSongList()) {
                            String youtubeLink = song.getLink();
                            Desktop.getDesktop().browse(new URI(youtubeLink));
                            Thread.sleep(song.getDuration() * 1000L);
                        }
                    }
                }
                if (!playlistFound) {
                    System.out.println("Playlist not found");
                }
            } catch (URISyntaxException | IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public Playlist checkPlaylistName(ArrayList<Playlist> allPlaylists, String nameToBeChecked) {
        for (Playlist playlist : allPlaylists) {
            if (playlist.getPlaylistName().equals(nameToBeChecked)) {
                return playlist;
            }
        }
        return null;
    }


}
