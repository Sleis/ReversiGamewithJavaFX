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
public class PlayerColorTest {

    /**
     * Test of getYourColor method, of class PlayerColor.
     */
    @Test
    public void testGetYourColor() {
        PlayerColor instance = new PlayerColor("teszt", "teszt");
        String expResult = "teszt";
        assertEquals(expResult, instance.getYourColor());
    }

    /**
     * Test of getEnemyColor method, of class PlayerColor.
     */
    @Test
    public void testGetEnemyColor() {
        PlayerColor instance = new PlayerColor("teszt", "teszt");
        String expResult = "teszt";
        assertEquals(expResult, instance.getEnemyColor());
    }

    /**
     * Test of setYourColor method, of class PlayerColor.
     */
    @Test
    public void testSetYourColor() {
        String yourColor = "teszt";
        PlayerColor instance = new PlayerColor("nincs", "nincs");
        instance.setYourColor(yourColor);
        assertEquals(yourColor, instance.getYourColor());
    }

    /**
     * Test of setEnemyColor method, of class PlayerColor.
     */
    @Test
    public void testSetEnemyColor() {
        String enemyColor = "teszt";
        PlayerColor instance = new PlayerColor("nincs", "nincs");
        instance.setEnemyColor(enemyColor);
        assertEquals(enemyColor, instance.getEnemyColor());
    }

    /**
     * Test of hashCode method, of class PlayerColor.
     */
    @Test
    public void testHashCode() {
        PlayerColor test = new PlayerColor();
        assertEquals(7, test.hashCode());
    }

    /**
     * Test of hashCode method, of class PlayerColor.
     */
    @Test
    public void testEquals() {
        PlayerColor test1 = new PlayerColor("blue", "green");
        PlayerColor test2 = new PlayerColor("blue", "green");
        PlayerColor test3 = new PlayerColor("yellow", "green");
        PlayerColor test4 = new PlayerColor("yellow", "blue");
        Player test = new Player("name", 0);
        
        assertTrue(test1.equals(test2));
        assertFalse(test2.equals(test3));
        assertFalse(test3.equals(test4));
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(null));
        assertFalse(test1.equals(test));
        
    }
    
}
