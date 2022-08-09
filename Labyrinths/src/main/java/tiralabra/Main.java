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
            System.out.println("Printing out the labyrinth format:\n");
            testilabbis.printLabyrinth();
            
            System.out.println("\n--------------------------------\n");
            System.out.println("Executing the sidewinder algorithm to generate a maze");
            System.out.println("\n--------------------------------\n");
            
            long startmilli = System.currentTimeMillis();
            long start = System.nanoTime();
            
            testilabbis.sideWinder();
            
            // System calls 
            long end = System.nanoTime() - start;
            long endmilli = System.currentTimeMillis() - startmilli;
            
            System.out.println("Maze after executing sidewinder: ");
            
            testilabbis.printLabyrinth();
            
            System.out.println("\n--------------------------------\n");
            
            System.out.println("Time taken (nanoseconds):  " + end);
            System.out.println("Time taken (milliseconds): " + endmilli);
            
            System.out.println("Bye bye ...");
        } catch (Exception e) {
            System.out.println("Virhe syötteessä: " + e);
        }
    }
    
}
