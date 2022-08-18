/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lbsarast
 */
public class CellTest {
    
    private Cell testCell;
    
    @Before
    public void setUp() {
        testCell = new Cell(6, 2);
    }
    
    /**
     * Test the setWalls -function
     */
    @Test
    public void testSetWalls() {
        testCell.setWalls(0, true);
        testCell.setWalls(1, true);
        boolean[] cellwalls = testCell.getWalls();
        assertEquals(cellwalls[0], true);
        assertEquals(cellwalls[1], true);
       
        testCell.setWalls(1, false);
        cellwalls = testCell.getWalls();
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
        
        boolean compareIdentical = testCell.compareTo(identical);
        boolean compareFake = testCell.compareTo(fake);
        
        assertEquals(true, compareIdentical);
        assertEquals(false, compareFake);
    }
}
