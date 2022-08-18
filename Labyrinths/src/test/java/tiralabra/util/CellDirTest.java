/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.util;

import static org.junit.Assert.*;
import org.junit.Test;

import tiralabra.domain.Cell;

/**
 *
 * @author lbsarast
 */
public class CellDirTest {
    
    /**
     * Tests the CellDir class
     */
    @Test
    public void testCellDir() {
        Cell testCell = new Cell(2, 4);
        CellDir testCD = new CellDir(testCell, 2);
        
        Cell identical = new Cell(2, 4);
        Cell fake = new Cell(4, 2);
        assertTrue(testCD.getCell().compareTo(identical));
        assertFalse(testCD.getCell().compareTo(fake));
        
        Integer identicaldir = 2;
        assertEquals(testCD.getDir(), identicaldir);
    }
    
}