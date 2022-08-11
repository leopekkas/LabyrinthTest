/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.util;

import tiralabra.domain.Cell;

/**
 * CellDir contains information about a specific cell
 * and a direction we've arrived from to this cell
 * 
 * The usage is intended for implementing Wilson's algorithm
 * 
 * @author lbsarast
 */
public class CellDir {
    
    private Cell cellEntry;
    private Integer dir;
    
    /**
     * Constructor
     * 
     * @param cellEntry Cell
     * @param dir Direction we come from
     */
    public CellDir(Cell cellEntry, Integer dir) {
        this.cellEntry = cellEntry;
        this.dir = dir;
    }
    
    /**
     * 
     * @return Cell
     */
    public Cell getCell() {
        return this.cellEntry;
    }
    
    /**
     * 
     * @return Direction we come from 
     */
    public Integer getDir() {
        return this.dir;
    }
    
}
