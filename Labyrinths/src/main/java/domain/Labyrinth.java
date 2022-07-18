package domain;

/**
 *
 * @author lbsarast
 */

// 2D maze skeleton, filled with zeros
public class Labyrinth {
    final int height;
    final int width;
    
    private int[][] maze;
    
    public Labyrinth(int height, int width) {
        this.height = height;
        this.width = width;
        // Note!
        // I think Java does 2D arrays with the first parameter
        // being the x-coordinate(?)
        this.maze = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                maze[i][j] = 0;
            }
        }
        
    }
    
    public void printLabyrinth() {
        for (int i = 0; i < this.width; i++) {
            System.out.print("_");
        }
        // Formatting, artificial linebreak
        System.out.println("");
        
        for (int i = 0; i < this.height; i++) {
            for (int j = -1; j < this.width+1; j++) {
                if (j == this.width || j == -1) {
                    System.out.print("|");
                } else {
                    int value = this.maze[i][j];
                    if (value == 0) {
                        System.out.print(" ");
                    } else if (value == 1) {
                        System.out.print("+");
                    }
                }
                
            }
            
            // Linebreak so we move to the next line
            System.out.println("");
        }
        for (int i = 0; i < this.width; i++) {
            System.out.print("_");
        }
    }
}
