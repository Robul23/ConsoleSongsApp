package Classes;

import java.util.Scanner;

public class CrudPlaylist implements ICrudPlaylist {


    @Override
    public void createPlaylistRandomSongs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numarul de melodii din playlist");
        int numberOfSongs = sc.nextInt();
        System.out.println("Nume playlist:");
        String playlistName =  sc.nextLine();



    }
}
