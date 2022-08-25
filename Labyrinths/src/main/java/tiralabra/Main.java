package tiralabra;

import java.util.Scanner;

import tiralabra.domain.Labyrinth;
import tiralabra.testing.Tester;

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
        Tester testeri = new Tester();
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome! Here you can test out the Sidewinder algorithm"
                    + " and Wilson's algorithm.");
        while (true) {            
        
            System.out.println("\n============  Main Menu  ============");
            System.out.println("Please type one of the following:");
            System.out.println("          S : Run the sidewinder algorithm");
            System.out.println("          W : Run Wilson's algorithm");
            System.out.println("    SW | WS : Run both algorithms");
            System.out.println("          T : Run performance tests for both algorithms");
            System.out.println("         TL : Run limited performance tests");
            System.out.println("<empty> | q : Quit the program");
            System.out.println("=====================================");
            
            try {
                String input = String.valueOf(reader.nextLine());
                if (input.equalsIgnoreCase("S")) {
                    execSidewinder();
                } else if (input.equalsIgnoreCase("W")) {
                    execWilsons();
                } else if (input.equalsIgnoreCase("SW") || input.equalsIgnoreCase("WS")) {
                    execDouble();
                
                // Improve to produce charts    
                } else if (input.equalsIgnoreCase("T")) {
                    System.out.println("Executing performance tests for the algorithms");
                    execTests(15);                    
                } else if (input.equalsIgnoreCase("TL")) {
                    System.out.println("Executing limited performance tests for the algorithms");
                    execTests(10);                    
                } else if (input.equalsIgnoreCase("q") || input.equals("")) {
                    System.out.println("Quitting ... ");
                    System.out.println("Thank you for using the program!");
                    break;
                } else {
                    System.out.println("Unknown input, try again");
                }
                
                
            } catch (Exception e) {
                System.out.println("An unknown error occurred, quitting ...");
            }
        }
    }
    
    /**
     * Executes the sidewinder algorithm for a labyrinth of specified size
     */
    public static void execSidewinder() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please specify the span (NxN) of"
                + " the maze as an integer");
        try {
            int span = Integer.valueOf(reader.nextLine());                    
        
            Labyrinth swlab = new Labyrinth(span);
            System.out.println("Printing out the labyrinth format:\n");
            swlab.printLabyrinth();

            System.out.println("\n=====================================\n");

            long startmilli = System.currentTimeMillis();
            long start = System.nanoTime();

            swlab.sideWinder();

            // System calls 
            long end = System.nanoTime() - start;
            long endmilli = System.currentTimeMillis() - startmilli;

            System.out.println("Maze after executing sidewinder: ");

            swlab.printLabyrinth();

            System.out.println("\n=====================================\n"
                    + "Time taken (nanoseconds):  " + end);
            System.out.println("Time taken (milliseconds): " + endmilli);
        } catch (Exception e) {
            System.out.println("An unknown error occurred, quitting ...");
        }    
    }
    
    /**
     * Executes Wilson's algorithm for a labyrinth of specified size
     */
    public static void execWilsons() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please specify the span (NxN) of"
                + " the maze as an integer");
        try {
            int span = Integer.valueOf(reader.nextLine());                    
 
            Labyrinth walab = new Labyrinth(span);
            System.out.println("Printing out the labyrinth format:\n");
            walab.printLabyrinth();

            System.out.println("\n=====================================\n");

            long startmilli = System.currentTimeMillis();
            long start = System.nanoTime();

            walab.wilsonsAlgorithm();

            // System calls 
            long end = System.nanoTime() - start;
            long endmilli = System.currentTimeMillis() - startmilli;

            System.out.println("Maze after executing Wilson's algorithm: ");

            walab.printLabyrinth();

            System.out.println("\n=====================================\n"
                    + "Time taken (nanoseconds):  " + end);
            System.out.println("Time taken (milliseconds): " + endmilli);
        } catch (Exception e) {
            System.out.println("An unknown error occurred, quitting ...");
        }
    }
    
    /**
     * Executes the sidewinder and Wilson's algorithm for a labyrinth of specified size
     */
    public static void execDouble() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please specify the span (NxN) of"
                + " the maze as an integer");
        try {
            int span = Integer.valueOf(reader.nextLine());                    
        
            Labyrinth swlab = new Labyrinth(span);
            System.out.println("Printing out the labyrinth format:\n");
            swlab.printLabyrinth();

            System.out.println("\n==============================\n");

            long startmillisw = System.currentTimeMillis();
            long startsw = System.nanoTime();

            swlab.sideWinder();

            // System calls 
            long endsw = System.nanoTime() - startsw;
            long endmillisw = System.currentTimeMillis() - startmillisw;

            System.out.println("Maze after executing sidewinder: ");

            swlab.printLabyrinth();
        
            // =========================================================
            // Wilson time
            // =========================================================
            
            // "Zero out" the maze in between
            Labyrinth walab = new Labyrinth(span);
            
            System.out.println("\n=====================================\n");

            long startmilliwa = System.currentTimeMillis();
            long startwa = System.nanoTime();

            walab.wilsonsAlgorithm();

            // System calls 
            long endwa = System.nanoTime() - startwa;
            long endmilliwa = System.currentTimeMillis() - startmilliwa;

            System.out.println("Maze after executing Wilson's algorithm: ");

            walab.printLabyrinth();

            System.out.println("\n=====================================\n"
                            + String.format("%37s", "Sidewinder") + String.format("%3s" ," vs. ") 
                            + String.format("%3s","Wilson's"));
            System.out.println("Time taken (nanoseconds) : " + String.format("%-12s", endsw) 
                    + " | " + String.format("%-12s", endwa));
            System.out.println("Time taken (milliseconds): " + String.format("%-12s", endmillisw)
                    + " | " + String.format("%-12s", endmilliwa));
        
        } catch (Exception e) {
            System.out.println("An unknown error occurred, quitting ...");
        }    
    }
    
    /**
     * For executing performance tests for the algorithms
     * @param scale Scale of the testing
     */
    public static void execTests(int scale) {
        Tester labtester = new Tester();
        labtester.testSidewinder(scale);
        labtester.testWilsons(scale);        
    }
    
}
