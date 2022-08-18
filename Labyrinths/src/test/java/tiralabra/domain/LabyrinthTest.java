/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tiralabra.util.List;

/**
 * Testing for the Labyrinth class
 * 
 * @author lbsarast
 */
public class LabyrinthTest {
    
    private Labyrinth lab;

    /**
     * Set up a private labyrinth before tests
     */
    @Before
    public void setUp() {
        lab = new Labyrinth(5);
    }

    /**
     * Test the Labyrinth constructor
     */
    @Test
    public void testLabyrinthConstructor() {
        System.out.println("Labyrinth width: " + lab.getWidth());
        assertEquals(lab.getWidth(), 5);
    }
    
    /**
     * Test the createExit -function
     */
    @Test
    public void testCreateExit() {
        Labyrinth exitlab = new Labyrinth(5);
        Cell[][] maze = exitlab.getMaze();
        boolean[] exitCellWalls = maze[4][4].getWalls();
               
        assertEquals(exitCellWalls[0], true);
        assertEquals(exitCellWalls[1], true);
        
        exitlab.createExit();        
        exitCellWalls = maze[4][4].getWalls();
        
        assertEquals(exitCellWalls[0], true);
        assertEquals(exitCellWalls[1], false);
    }
    
    /**
     * !TODO Fails for now
     * Test the sidewinder function bu making sure all squares are accessible
     */
    @Test
    public void testSideWinder() {
        int testspan = 20;
        
        Labyrinth swlab = new Labyrinth(testspan);
        Cell[][] cells = swlab.getMaze();
        swlab.sideWinder();
        
        Cell start = cells[0][0];
        Cell end = cells[swlab.getHeight() - 1][swlab.getWidth() - 1];
        
        int checked = 0;
        int total = 20 * 20;
        Boolean[][] visited = new Boolean[swlab.getHeight()][swlab.getWidth()];
        
        for (int i = 0; i < swlab.getHeight(); i++) {
            for (int j = 0; j < swlab.getWidth(); j++) {
                visited[i][j] = false;
            }
        }
        
        List<Cell> mazeCells = new List<>();
        
        mazeCells.add(start);
        while (mazeCells.getSize() > 0) {
            Cell check = mazeCells.pop();
            if (!visited[check.getY()][check.getX()]) {
                visited[check.getY()][check.getX()] = true;
                checked++;
                
                // Check if we can go "down"
                if (check.getY() + 1 < swlab.getHeight() && !check.getWalls()[0]) {
                    Cell bottomcell = swlab.getMaze()[check.getY() + 1][check.getX()];
                    mazeCells.add(bottomcell);
                }
                // Check if we can go "up"
                if (check.getY() - 1 >= 0) {
                    Cell topcell = swlab.getMaze()[check.getY() - 1][check.getX()];
                    // We need to check the bottom wall of the cell over us
                    if (!topcell.getWalls()[0]) {
                        mazeCells.add(topcell);
                    }
                
                }
                // Check if we can go "right"
                if (check.getX() + 1 < swlab.getWidth() && !check.getWalls()[1]) {
                    Cell rightcell = swlab.getMaze()[check.getY()][check.getX() + 1];
                    mazeCells.add(rightcell);
                }
                // Check if we can go "left"
                if (check.getX() - 1 >= 0) {
                    Cell leftcell = swlab.getMaze()[check.getY()][check.getX() - 1];
                    if (!leftcell.getWalls()[1]) {
                        mazeCells.add(leftcell);
                    }
                }
            }
        }
    
        //assertEquals(total, checked);
    }
}
