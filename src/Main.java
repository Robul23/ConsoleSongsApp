import Classes.CrudPlaylist;
import Classes.CrudSongs;
import Classes.Playlist;
import Classes.Song;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        ArrayList<Playlist> allPlaylists = new ArrayList<>();
        ArrayList<Song> songsList = new ArrayList<>();

        CrudSongs crudSongs = new CrudSongs();
        CrudPlaylist crudPlaylist = new CrudPlaylist();
        Scanner sc = new Scanner(System.in);

        boolean isRunning = true;

        System.out.println("Welcome to my songs management application");
        while (isRunning) {
            System.out.println("1: Add a song");
            System.out.println("2: Delete song");
            System.out.println("3: See songs to database");
            System.out.println("4: Create a playlist of random 'n' songs");
            System.out.println("5: Add a song from database to a playlist (by artist and title)");
            System.out.println("6: Add all songs to database by an artist to a playlist");
            System.out.println("7: Play the songs from a playlist one by one");
            System.out.println("8: See all playlists created");
            System.out.println("0: Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> crudSongs.addSong();
                case 2 -> crudSongs.deleteSong();
                case 3 -> crudSongs.seeAll();
                case 4 -> {
                    crudSongs.storeAllSongsInArray(songsList);
                    crudPlaylist.createPlaylistRandomSongs(songsList, allPlaylists);
                }
                case 5 -> crudPlaylist.addSongsToPlaylistByArtistAndTitle(allPlaylists);
                case 6 -> crudPlaylist.addAllTheSongFromAnArtist(allPlaylists);
                case 7 -> crudPlaylist.playPlaylist(allPlaylists);
                case 8 -> crudPlaylist.seeAllPlaylists(allPlaylists);
                case 0 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }
        }


    }


}