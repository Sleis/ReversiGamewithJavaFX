package Model;

/*
 * #%L
 * Reversi
 * %%
 * Copyright (C) 2016 University of Debrecen, Faculty of Informatics
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


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
