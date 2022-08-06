/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lbsarast
 */
public class CellTest {
    
    private Cell c;
    
    public CellTest() {
    }
    
    @Before
    public void setUp() {
        c = new Cell(6, 2);
    }
    
    /**
     * Test the setWalls -function
     */
    @Test
    public void testSetWalls() {
        c.setWalls(0, true);
        c.setWalls(1, true);
        boolean[] cellwalls = c.getWalls();
        assertEquals(cellwalls[0], true);
        assertEquals(cellwalls[1], true);
       
        c.setWalls(1, false);
        cellwalls = c.getWalls();
        assertEquals(cellwalls[0], true);
        assertEquals(cellwalls[1], false);
    }
    
    /**
     * Cell comparison function test
     */
    @Test
    public void testCompare() {
        Cell identical = new Cell(6, 2);
        Cell fake = new Cell(2, 6);
        
        boolean compareIdentical = c.compareTo(identical);
        boolean compareFake = c.compareTo(fake);
        
        assertEquals(true, compareIdentical);
        assertEquals(false, compareFake);
    }
}
