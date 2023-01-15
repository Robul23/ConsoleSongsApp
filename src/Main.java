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

        ArrayList<Song> arrayList = new ArrayList<>();
        HashSet<Song> songsHashSet = new HashSet<>();
        Playlist playlist = new Playlist("numerandom", songsHashSet);


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
            System.out.println("0: Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> crudSongs.addSong();
                case 2 -> crudSongs.deleteSong();
                case 3 -> crudSongs.seeAll();
                case 4 -> crudPlaylist.createPlaylistRandomSongs(arrayList);
                case 5 -> crudPlaylist.addSongsToPlaylistByArtistAndTitle();
                case 6 -> crudPlaylist.addAllTheSongFromAnArtist();
                case 7 -> crudPlaylist.playPlaylist(playlist);
                case 0 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }
        }


    }


}