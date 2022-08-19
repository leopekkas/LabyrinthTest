package tiralabra.testing;

import java.util.Arrays;

import tiralabra.domain.Labyrinth;

/**
 * Tester class for performance and scalability tests
 *
 */
public class Tester {

    /**
     * Sizes of the labyrinths we'll test
     */
    private int[] tests;
    
    /**
     * Initialize test sizes, using the formula:
     * 2 * N^2, where N has values ranging from 1 to 20
     */
    public Tester() {
        this.tests = new int[30];
        for (int i = 0; i < 30; i++) {
            this.tests[i] = 2 * (i + 1) * (i + 1); 
        }
    }
    
    /**
     * Tests sidewinders performance by running a few runs and 
     * taking the average value of the run times
     * 
     * @param scale Upper limit of the test cases
     */
    public void testSidewinder(int scale) {
        if (scale > this.tests.length) {
            System.out.println("Scale of tests too large, Nullpointers would occur");
            return;
        }
        System.out.println("\n--------------------------------\n");
        System.out.println("Executing performance tests for the sidewinder algorithm");
        System.out.println("\n--------------------------------\n");
            
        for (int i = 0; i < scale; i++) {
            long[] timings = new long[5];
            
            // Run the tests a few times to get an average
            for (int j = 0; j < timings.length; j++) {
                Labyrinth lab = new Labyrinth(this.tests[i]);
                long startmilli = System.currentTimeMillis();
                lab.sideWinder();
                long endmilli = System.currentTimeMillis();
                timings[j] = endmilli - startmilli;
            }
            Arrays.sort(timings);
            long avg = timings[timings.length / 2];
            System.out.println("Size " + this.tests[i] + " took " + avg 
                    + " milliseconds to compute");
            if (i % 5 == 0) {
                System.out.println("Timestep " + i + "/" + scale);
            }
        }
        
        System.out.println("\n--------------------------------\n");
        System.out.println("Sidewinder performance tests done");
        System.out.println("\n--------------------------------\n");
    }
    
    /**
     * Tests sidewinders performance by running a few runs and 
     * taking the average value of the run times
     * 
     * @param scale Upper limit of the test cases
     */
    public void testWilsons(int scale) {
        if (scale > this.tests.length) {
            System.out.println("Scale of tests too large, Nullpointers would occur");
            return;
        }
        
        System.out.println("\n--------------------------------\n");
        System.out.println("Executing performance tests for Wilson's algorithm");
        System.out.println("\n--------------------------------\n");
            
        for (int i = 0; i < scale; i++) {
            long[] timings = new long[5];
            
            // Run the tests a few times to get an average
            for (int j = 0; j < timings.length; j++) {
                Labyrinth lab = new Labyrinth(this.tests[i]);
                long startmilli = System.currentTimeMillis();
                lab.wilsonsAlgorithm();
                long endmilli = System.currentTimeMillis();
                timings[j] = endmilli - startmilli;
            }
            Arrays.sort(timings);
            long avg = timings[timings.length / 2];
            System.out.println("Size " + this.tests[i] + " took " + avg 
                    + " milliseconds to compute");
            if (i % 5 == 0) {
                System.out.println("Timestep " + i + "/" + scale);
            }
        }
        
        System.out.println("\n--------------------------------\n");
        System.out.println("Wilson's algorithm performance tests done");
        System.out.println("\n--------------------------------\n");
    }
    
}
