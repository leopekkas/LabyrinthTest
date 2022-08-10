/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.domain;

/**
 * Represents a single cell or a "square" insided the labyrinth
 * 
 * @author lbsarast
 */
public class Cell {
   
   private int x;
   private int y;
   
   /**
    * Path we can move to, from top-down, or left-right
    */
   private boolean[] walls;
   
   /**
    * Creates a new cell with two walls surrounding it
    * 
    * @param x x-coordinate inside maze
    * @param y y-coordinate inside maze
    */
   public Cell(int x, int y) {
        if (x < 0 || y < 0) {
            System.out.println("Error: Initializing a cell with negative coordinates, exiting");
            return;
        }
        // Initialize two walls, over this cell and on its right side
        this.walls = new boolean[2];
        for (int i = 0; i < this.walls.length; i++) {
            this.walls[i] = true;
        }
        
        this.x = x;
        this.y = y;
   }
   
   /**
     *
     * @return Return cell x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     *
     * @return Return cell y-coordinate
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * 
     * @return Values of the walls for this cell
     */
    public boolean[] getWalls() {
        return this.walls;
    }
    
    /**
     * 
     * @param dir dir of the wall we want to change
     * @param value true or false, wall or not
     */
    public void setWalls(int dir, boolean value) {
        this.walls[dir] = value;
    }
    
    /**
     * For comparing different cells by their coordinates
     * 
     * @param c Cell we're comparing this to 
     * @return True for identical coordinates
     */
    public boolean compareTo(Cell c) {
        return this.x == c.getX() && this.y == c.getY();
    }
    
    /**
     * Print out the cell 
     */
    public void printCell() {   
        // Doesn't have walls around this cell
        if (!this.walls[0] && !this.walls[1]) {
            System.out.print("  ");
            return;
        }
        
        if (this.walls[0]) {
            System.out.print("_");
        } else {
            System.out.print(" ");
        }
        
        if (this.walls[1]) {
            System.out.print("|");
        } else {
            System.out.print("_");
        }
    }
}
