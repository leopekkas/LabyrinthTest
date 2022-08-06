package tiralabra.domain;

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
