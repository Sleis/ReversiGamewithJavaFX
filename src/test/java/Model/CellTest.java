/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sleis
 */
public class CellTest {

    /**
     * Test of getColor method, of class Cell.
     */
    @Test
    public void testGetColor() {
        Cell instance = new Cell("teszt");
        String expResult = "teszt";
        assertEquals(expResult, instance.getColor());

    }

    /**
     * Test of setColor method, of class Cell.
     */
    @Test
    public void testSetColor() {
        String color = "teszt";
        Cell instance = new Cell();
        instance.setColor(color);
        assertEquals(color, instance.getColor());
    }

}
