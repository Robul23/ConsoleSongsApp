import Classes.CrudPlaylist;
import Classes.CrudSong;
import Classes.Playlist;
import Classes.Song;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ArrayList<Playlist> allPlaylists = new ArrayList<>(); // ArrayList for all playlists
        ArrayList<Song> songsList = new ArrayList<>(); //ArrayList for all the database songs

        CrudSong crudSong = new CrudSong();
        CrudPlaylist crudPlaylist = new CrudPlaylist();

        Scanner sc = new Scanner(System.in); //Scanner for choices
        Scanner playlistScanner = new Scanner(System.in); //Scanner for random songs number in playlist

        boolean isRunning = true;

        System.out.println("Welcome to my songs management application");
        while (isRunning) {
            System.out.println("1: Add a song");
            System.out.println("2: Delete song");
            System.out.println("3: See all songs from database");
            System.out.println("4: Create a playlist of random 'n' songs");
            System.out.println("5: Add a song from database to a playlist (by artist and title)");
            System.out.println("6: Add all songs to database by an artist to a playlist");
            System.out.println("7: Play the songs from a playlist one by one");
            System.out.println("8: See all playlists created");
            System.out.println("0: Exit");
            System.out.println("Enter your choice");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> crudSong.addSong();
                    case 2 -> crudSong.deleteSong();
                    case 3 -> crudSong.seeAll();
                    case 4 -> {
                        crudSong.storeAllSongsInArray(songsList);
                        crudPlaylist.createPlaylistRandomSongs(songsList, allPlaylists);
                    }
                    case 5 -> crudPlaylist.addSongsToPlaylistByArtistAndTitle(allPlaylists);
                    case 6 -> crudPlaylist.addAllTheSongFromAnArtist(allPlaylists);
                    case 7 -> {
                        System.out.println("Playlist name :");
                        String playedPlaylistName = playlistScanner.next();
                        Thread thread = crudPlaylist.playPlaylist(allPlaylists, playedPlaylistName);
                        thread.start();

                    }
                    case 8 -> crudPlaylist.seeAllPlaylists(allPlaylists);
                    case 0 -> isRunning = false;
                    default -> System.out.println("Invalid choice");
                }
            }
            sc.close();
            playlistScanner.close();

        }
    }
