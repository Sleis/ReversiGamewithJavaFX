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
public class PositionTest {

    /**
     * Test of getSor method, of class Position.
     */
    @Test
    public void testGetSor() {
        Position instance = new Position(5, 5);
        int expResult = 5;
        assertEquals(expResult, instance.getSor());
    }

    /**
     * Test of getOszlop method, of class Position.
     */
    @Test
    public void testGetOszlop() {
        Position instance = new Position(5, 5);
        int expResult = 5;
        assertEquals(expResult, instance.getOszlop());
    }

    /**
     * Test of setSor method, of class Position.
     */
    @Test
    public void testSetSor() {
        int sor = 10;
        Position instance = new Position(5,5);
        instance.setSor(sor);
        assertEquals(sor, instance.getSor());
    }

    /**
     * Test of setOszlop method, of class Position.
     */
    @Test
    public void testSetOszlop() {
        int oszlop = 10;
        Position instance = new Position(5,5);
        instance.setOszlop(oszlop);
        assertEquals(oszlop, instance.getOszlop());
    }

}
