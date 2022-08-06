package tiralabra;

import tiralabra.domain.Labyrinth;
import java.util.Scanner;

/**
 * 
 * @author lbsarast
 */
public class Main {

    /**
     * Main function
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Labyrintin koko");
        
        try {
            int size = Integer.valueOf(reader.nextLine());
            Labyrinth testilabbis = new Labyrinth(size, size);
            
            testilabbis.printLabyrinth();
        } catch (Exception e) {
            System.out.println("Virhe syötteessä: " + e);
        }
    }
    
}
