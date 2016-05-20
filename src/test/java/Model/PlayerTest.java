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


import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iványi Dániel
 */
public class PlayerTest {

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        Player instance = new Player("Teszt", 10);
        String expResult = "Teszt";
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of getPoints method, of class Player.
     */
    @Test
    public void testGetPoints() {
        Player instance = new Player("Teszt", 10);
        int expResult = 10;
        assertEquals(expResult, instance.getPoints());
    }

    /**
     * Test of getLocalDate method, of class Player.
     */
    @Test
    public void testGetLocalDate() {
        Player instance = new Player("Teszt", 10);
        LocalDate expResult = LocalDate.now();
        assertEquals(expResult, instance.getLocalDate());
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        String name = "Teszt";
        Player instance = new Player("Dani", 2);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of setPoints method, of class Player.
     */
    @Test
    public void testSetPoints() {
        int points = 50;
        Player instance = new Player("Teszt", 10);
        instance.setPoints(points);
        assertEquals(points, instance.getPoints());
    }

    /**
     * Test of setDate method, of class Player.
     */
    @Test
    public void testSetDate() {
        LocalDate date = LocalDate.MAX;
        Player instance = new Player("Teszt", 10);
        instance.setDate(date);
        assertEquals(date, instance.getLocalDate());
    }

}
