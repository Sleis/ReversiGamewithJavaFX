/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import javafx.util.converter.LocalDateStringConverter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sleis
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
