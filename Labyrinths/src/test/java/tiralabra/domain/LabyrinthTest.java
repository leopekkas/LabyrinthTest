/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tiralabra.domain.Labyrinth;
import tiralabra.domain.Cell;

/**
 * Testing for the Labyrinth class
 * 
 * @author lbsarast
 */
public class LabyrinthTest {
    
    private Labyrinth lab;
    
    public LabyrinthTest() {
    }
    
    @Before
    public void setUp() {
        lab = new Labyrinth(5, 5);
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
        Labyrinth exitlab = new Labyrinth(5, 5);
        Cell[][] maze = exitlab.getMaze();
        boolean[] exitCellWalls = maze[4][4].getWalls();
               
        assertEquals(exitCellWalls[0], true);
        assertEquals(exitCellWalls[1], true);
        
        exitlab.createExit();        
        exitCellWalls = maze[4][4].getWalls();
        
        assertEquals(exitCellWalls[0], true);
        assertEquals(exitCellWalls[1], false);
    }
}
