package tiralabra.domain;

import java.util.ArrayList;
import java.util.Random;

import tiralabra.util.CellDir;

/**
 * Class for the labyrinth, contains information 
 * on the labyrinth height and width
 * 
 * @author lbsarast
 */

public class Labyrinth {
    
    final int height;
    final int width;
    
    private Cell[][] maze;
    
    /**
     * Labyrinth constructor
     * 
     * @param height Height of the labyrinth
     * @param width  Width of the labyrinth
     */
    public Labyrinth(int height, int width) {
        this.height = height;
        this.width = width;
        
        this.maze = new Cell[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = new Cell(i, j);
            }
        }
        
    }
    
    /**
     * Runs the sidewinder -algorithm for this labyrinth 
     */
    public void sideWinder() {
        createExit();
        Random random = new Random();

        for (int i = 0; i < this.height; i++) {
            // Initial cell in this runset
            int initialCell = 0;

            for (int j = 0; j < this.width; j++) {
                int dir = random.nextInt(2);
                // Continue either downwards (0) or right (1) depending on random chance and if we're on a border
                if (i > 0 && (j + 1 == this.width || dir == 0)) {
                    // Remove the "upper" wall of a random square in this runset
                    int randomRemove = random.nextInt(j - initialCell + 1);
                    // Remove the wall over this square (so the downwards wall of the Cell over us)
                    Cell chosen = this.maze[i - 1][initialCell + randomRemove];
                    chosen.setWalls(0, false);
                    initialCell = j + 1;

                } else if (j + 1 < this.width) {
                    // Remove the rightmost wall and go right
                    Cell current = this.maze[i][j];
                    current.setWalls(1, false);
                }
            }
        }

    }
    
    /**
     * Returns the neighboring cells for this cell in a list
     *
     * @param current Current cell
     * @return An ArrayList of the neighboring cells
     */
    public ArrayList<CellDir> getNeighbors(Cell current) {
        ArrayList<CellDir> neighbors = new ArrayList<>();
        
        // Has a top neighbor
        if (current.getY() - 1 >= 0) {
            neighbors.add(new CellDir(this.maze[current.getY() - 1][current.getX()], 3));

        }
        // Has a bottom neighbor
        if (current.getY() + 1 < this.width) {
            neighbors.add(new CellDir(this.maze[current.getY() + 1][current.getX()], 1));
        }
            
        // Has a left neighbor
        if (current.getX() - 1 >= 0) {
            neighbors.add(new CellDir(this.maze[current.getY()][current.getX() - 1], 0));
        }
        
        // Has a right neighbor
        if (current.getX() + 1 < this.width) {
            neighbors.add(new CellDir(this.maze[current.getY()][current.getX() + 1], 2));
        }

        return neighbors;
    }
    
    /**
     * Printing function for the maze
     */
    public void printLabyrinth() {
        System.out.println("");
        for (int i = 0; i < this.width * 2 - 1; i++) {
            System.out.print("_");
        }
        // Formatting, artificial linebreak
        System.out.println("");
        
        for (int i = 0; i < this.width; i++) {
            if (i == 0) {
                // Leave the left wall open
                System.out.print(" ");
            } else {
                System.out.print("|");
            }
            for (int j = 0; j < this.height; j++) {
                Cell c = this.maze[i][j];
                c.printCell();
            }
            System.out.println("");
        }
        
        // "Close" the bottom of the labyrinth
        for (int i = 0; i < this.width * 2 - 1; i++) {
            // Might not be portable, let's figure out something better
            char overline = '\u203E';
            System.out.print(overline);
        }
    }
    
    /**
     * Create an exit in the bottom right of the maze
     */
    public void createExit() {
        Cell exit = this.maze[this.height - 1][this.width - 1];

        // Set the "left" wall open
        exit.setWalls(1, false);
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public Cell[][] getMaze() {
        return this.maze;
    }
}
