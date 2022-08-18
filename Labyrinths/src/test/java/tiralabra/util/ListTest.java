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
 * Tests for the class List
 * 
 * @author lbsarast
 */
public class ListTest {
   
    private List testList = new List<>();    
    
    @Test
    public void testAdd() {
        int entryInt = -25;
        double entrydbl = 2.2;        
        Cell testCell = new Cell(2, 5);
        
        testList.add(entryInt);  
        testList.add(entrydbl);
        testList.add(testCell);
        
        Cell identical = new Cell(2, 5);
        
        int length = testList.getSize();
        
        // Bad conversion(?)
        double dblEntry = (double)testList.getIndex(length - 2);
        Cell cellEntry = (Cell)testList.getIndex(length - 1);
        
        assertEquals(testList.getIndex(length - 3), -25);
        assertEquals(dblEntry, 2.2, 0.01);
        assertTrue(cellEntry.compareTo(identical));
    }
    
    /**
     * Test if list delete works
     * (Consequently tests the shiftLeft function)
     */
    @Test
    public void testDelete() {
        testList = new List<>();
        int entryInt = -25;
        double entrydbl = 2.2;        
        Cell testCell = new Cell(2, 5);
        
        testList.add(entryInt);  
        testList.add(entrydbl);
        testList.add(testCell);
        
        assertEquals(testList.getSize(), 3);
        
        testList.delete(entryInt);
        
        assertFalse(testList.contains(entryInt));
        assertEquals(testList.getSize(), 2);
        
        testList.delete(testCell);
        assertFalse(testList.contains(testCell) && testList.contains(entrydbl));
        assertEquals(testList.getSize(), 1);
        
        // Try to delete the entry again
        // To make sure it doesn't delete something it isn't supposed to
        testList.delete(entryInt);
        
        assertFalse(testList.contains(entryInt));
        assertEquals(testList.getSize(), 1);
    }
    
    /**
     * Test the getIndex method
     */
    @Test
    public void testGetIndex() {
        testList = new List<>();
        
        int testval1 = 1;
        int testval2 = -1;
        testList.add(testval1);
        testList.add(testval2);
        
        Object entry0 = testList.getIndex(0);
        Object entry1 = testList.getIndex(1);
        
        assertEquals(entry0, 1);
        assertEquals(entry1,-1);
    }
    
    /**
     * Test the indexOfEntry method
     */
    @Test
    public void testIndexOfEntry() {
        testList = new List<>();
        
        int testval1 = 1;
        int testval2 = -1;
        Cell testCell = new Cell(1, 3);
        testList.add(testval1);
        testList.add(testval2);
        testList.add(testCell);
        
        int indexone = testList.indexOfEntry(testval1);
        int indextwo = testList.indexOfEntry(testval2);
        int indexthree = testList.indexOfEntry(testCell);
        
        assertEquals(indexone, 0);
        assertEquals(indextwo, 1);
        assertEquals(indexthree, 2);
        
        int indexfalse = testList.indexOfEntry(new Cell(1, 4));
        assertEquals(indexfalse, -1);
        
        Object falseIndex = testList.getIndex(5);
        // This seems like a bad test but passes
        assertEquals(falseIndex, null);
    }
    
    /**
     * Test the contains function
     */
    @Test
    public void testContains() {
        testList = new List<>();
        
        int testval1 = 1;
        int testval2 = -1;
        Cell testCell = new Cell(1, 3);
        
        assertFalse(testList.contains(testval1) 
                && testList.contains(testval2) 
                && testList.contains(testCell));
        
        testList.add(testval1);
        testList.add(testval2);
        testList.add(testCell);
        
        assertTrue(testList.contains(testval1) 
                && testList.contains(testval2)
                && testList.contains(testCell));
        
    }
    
}
