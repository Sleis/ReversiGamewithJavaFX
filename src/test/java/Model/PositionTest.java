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
