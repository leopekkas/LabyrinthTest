/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tiralabra.util;

/**
 * List design to replace ArrayList for the project
 * 
 * @author lbsarast
 */
public class List<T> {
    
    /**
     * Size of this list
     */
    private int size;
    
    /**
     * Values inside the list
     */
    private T[] values;
    
    /**
     * Constructor
     */
    public List() {
        this.size = 0;
        this.values = (T[]) new Object[10];
    }
    
    /**
     * Adds a value to the end of the list
     * 
     * @param value The value we want to add
     */
    public void add(T value) {
        if (this.size == this.values.length) {
            int newSize = this.values.length + this.values.length / 2;
            T[] biggerList = (T[]) new Object[newSize];
            
            // Simple copy into an expanded list
            for (int i = 0; i < this.values.length; i++) {
                biggerList[i] = this.values[i];
            }
            
            this.values = biggerList;
        }
        
        this.values[this.size] = value;
        this.size++;
    }
    
    /**
     * Returns the value at this index in the list
     * 
     * @param index 
     * @return Value at this index in the list
     */
    public T getIndex(int index) {        
        try {
            T value = this.values[index];
            return value;
        } catch (Exception e) {
            System.out.println("Error: List index out of range");
        }
        
        return null;
    }
    
    /**
     * Returns and deletes the first value in the list
     *
     * @return First value in the list
     */
    public T pop() {
        T value = this.values[0];
        delete(value);
        return value;
    }
    
    /**
     * Deletes the specified object from the list
     * @param value the object to be deleted
     */
    public void delete(T value) {
        int index = indexOfEntry(value);
        if (index == -1) {
            System.out.println("Error: List index out of range (-1)");
            return;
        }
        
        shiftLeft(index);
        this.size--;
    }
    
    /**
     * Fetch the index for a specific entry in the list
     *
     * @param entry The template entry we want to delete
     * @return Index of the entry in the list
     */
    public int indexOfEntry(T entry) {
        for (int i = 0; i < this.size; i++) {
            if (this.values[i].equals(entry)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Shifts all the entries after this index to the left,
     * useful in deletion of entries
     * 
     * @param index Index from where we want to move to the left
     */
    public void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }
    
    /**
     * Checks if the list contains this entry
     * 
     * @param entry Template entry
     * @return True if contains
     */
    public boolean contains(T entry) {
        return indexOfEntry(entry) != -1;
    }
    
    /**
     * 
     * @return size of the list
     */
    public int getSize() {
        return this.size;
    }
    
}
