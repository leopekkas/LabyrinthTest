/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import tiralabra.domain.Labyrinth;

/**
 * Testing for the Labyrinth class
 * 
 * @author lbsarast
 */
public class LabyrinthTest {
    
    public LabyrinthTest() {
    }

    /**
     * Test the Labyrinth constructor
     */
    @Test
    public void testLabyrinthConstructor() {
        int y = 0;
        int x = 0;
        Labyrinth lab = new Labyrinth(5, 5);
        System.out.println("Labyrinth width: " + lab.getWidth());
        assertEquals(lab.getWidth(), 5);
    }
}
