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
 * @author Iványi Dániel
 */
public class ReversiEngineTest {

    /**
     * Test of getBlackAndWhite method, of class ReversiEngine.
     */
    @Test
    public void testGetBlackAndWhite() {
        int[] teszt = new int[2];
        teszt[0] = 1;
        teszt[1] = 2;
        ReversiEngine instance = new ReversiEngine("teszt", teszt, true, 0);
        assertArrayEquals(teszt, instance.getBlackAndWhite());
    }

    /**
     * Test of isIsEnd method, of class ReversiEngine.
     */
    @Test
    public void testIsIsEnd() {
        ReversiEngine instance = new ReversiEngine("teszt", null, true, 0);
        assertTrue(instance.isIsEnd());
    }

    /**
     * Test of getMessage method, of class ReversiEngine.
     */
    @Test
    public void testGetMessage() {
        ReversiEngine instance = new ReversiEngine("teszt", null, true, 0);
        String expResult = "teszt";
        assertEquals(expResult, instance.getMessage());
    }

    /**
     * Test of getNextPlayer method, of class ReversiEngine.
     */
    @Test
    public void testGetNextPlayer() {
        ReversiEngine instance = new ReversiEngine("teszt", null, true, 2);
        int expResult = 2;
        assertEquals(expResult, instance.getNextPlayer());
    }

    /**
     * Test of setBlackAndWhite method, of class ReversiEngine.
     */
    @Test
    public void testSetBlackAndWhite() {
        int[] teszt = new int[2];
        teszt[0] = 1;
        teszt[1] = 2;
        ReversiEngine instance = new ReversiEngine();
        instance.setBlackAndWhite(teszt);
        assertArrayEquals(teszt, instance.getBlackAndWhite());
    }

    /**
     * Test of setIsEnd method, of class ReversiEngine.
     */
    @Test
    public void testSetIsEnd() {
        ReversiEngine instance = new ReversiEngine();
        instance.setIsEnd(true);
        assertTrue(instance.isIsEnd());
    }

    /**
     * Test of setMessage method, of class ReversiEngine.
     */
    @Test
    public void testSetMessage() {
        String message = "teszt";
        ReversiEngine instance = new ReversiEngine();
        instance.setMessage(message);
        assertEquals(message, instance.getMessage());
    }

    /**
     * Test of setNextPlayer method, of class ReversiEngine.
     */
    @Test
    public void testSetNextPlayer() {
        int nextPlayer = 2;
        ReversiEngine instance = new ReversiEngine();
        instance.setNextPlayer(2);
        assertEquals(nextPlayer, instance.getNextPlayer());
    }

    /**
     * Test of right method, of class ReversiEngine.
     */
    @Test
    public void testRight() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.right(all, index, color, isCheck));
        assertFalse(instance.right(all, index, color, true));
        all[2][3].setColor("black");
        assertTrue(instance.right(all, index, color, true));
        all[2][3].setColor("");
        assertFalse(instance.right(all, index, color, isCheck));
        all[2][3].setColor("black");
        all[2][4].setColor("");
        assertFalse(instance.right(all, index, color, isCheck));
        all[2][4].setColor("white");
        assertTrue(instance.right(all, index, color, isCheck));

    }

    /**
     * Test of up method, of class ReversiEngine.
     */
    @Test
    public void testUp() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.up(all, index, color, isCheck));

        all[1][2].setColor("");
        assertFalse(instance.up(all, index, color, isCheck));

        all[1][2].setColor("black");
        all[0][2].setColor("");
        assertFalse(instance.up(all, index, color, isCheck));

        all[0][2].setColor("");
        assertFalse(instance.up(all, index, color, isCheck));

        all[0][2].setColor("white");
        assertTrue(instance.up(all, index, color, true));
        assertTrue(instance.up(all, index, color, isCheck));

    }

    /**
     * Test of down method, of class ReversiEngine.
     */
    @Test
    public void testDown() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.down(all, index, color, isCheck));
        all[3][2].setColor("");
        assertFalse(instance.down(all, index, color, isCheck));
        all[3][2].setColor("black");
        all[4][2].setColor("");
        assertFalse(instance.down(all, index, color, isCheck));
        all[4][2].setColor("white");
        assertTrue(instance.down(all, index, color, true));
        assertTrue(instance.down(all, index, color, isCheck));
        for (int i = 3; i < 8; i++) {
            all[i][2].setColor("black");
        }
        assertFalse(instance.down(all, index, color, true));

    }

    /**
     * Test of left method, of class ReversiEngine.
     */
    @Test
    public void testLeft() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.left(all, index, color, isCheck));
        all[2][1].setColor("");
        assertFalse(instance.left(all, index, color, isCheck));
        all[2][1].setColor("black");
        all[2][0].setColor("");
        assertFalse(instance.left(all, index, color, isCheck));
        all[2][0].setColor("white");
        assertTrue(instance.left(all, index, color, true));
        assertTrue(instance.left(all, index, color, isCheck));
        all[2][0].setColor("black");
        assertFalse(instance.left(all, index, color, isCheck));

    }

    /**
     * Test of upandleft method, of class ReversiEngine.
     */
    @Test
    public void testUpandleft() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.upandleft(all, index, color, isCheck));
        all[1][1].setColor("");
        assertFalse(instance.upandleft(all, index, color, isCheck));
        all[1][1].setColor("black");
        all[0][0].setColor("");
        assertFalse(instance.upandleft(all, index, color, isCheck));
        all[0][0].setColor("white");
        assertTrue(instance.upandleft(all, index, color, true));
        assertTrue(instance.upandleft(all, index, color, isCheck));

    }

    /**
     * Test of upandright method, of class ReversiEngine.
     */
    @Test
    public void testUpandright() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.upandright(all, index, color, isCheck));
        all[1][3].setColor("");
        assertFalse(instance.upandright(all, index, color, isCheck));
        all[1][3].setColor("black");
        all[0][4].setColor("");
        assertFalse(instance.upandright(all, index, color, isCheck));
        all[0][4].setColor("white");
        assertTrue(instance.upandright(all, index, color, true));
        assertTrue(instance.upandright(all, index, color, isCheck));
        all[0][4].setColor("black");
        all[1][3].setColor("black");
        assertFalse(instance.upandright(all, index, color, isCheck));

    }

    /**
     * Test of downandleft method, of class ReversiEngine.
     */
    @Test
    public void testDownandleft() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.downandleft(all, index, color, isCheck));
        all[3][1].setColor("");
        assertFalse(instance.downandleft(all, index, color, isCheck));
        all[3][1].setColor("black");
        all[4][0].setColor("");
        assertFalse(instance.downandleft(all, index, color, isCheck));
        all[4][0].setColor("white");
        assertTrue(instance.downandleft(all, index, color, true));
        assertTrue(instance.downandleft(all, index, color, isCheck));
        all[4][0].setColor("black");
        all[3][1].setColor("black");
        assertFalse(instance.downandleft(all, index, color, isCheck));
    }

    /**
     * Test of downandright method, of class ReversiEngine.
     */
    @Test
    public void testDownandright() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        assertFalse(instance.downandright(all, index, color, isCheck));
        all[3][3].setColor("");
        assertFalse(instance.downandright(all, index, color, isCheck));
        all[3][3].setColor("black");
        all[4][4].setColor("");
        assertFalse(instance.downandright(all, index, color, isCheck));
        all[4][4].setColor("white");
        assertTrue(instance.downandright(all, index, color, true));
        assertTrue(instance.downandright(all, index, color, isCheck));
        for (int i = 3; i < 8; i++) {
            all[i][i].setColor("black");
        }
        assertFalse(instance.downandright(all, index, color, isCheck));

    }

    /**
     * Test of checkallway method, of class ReversiEngine.
     */
    @Test
    public void testCheckallway() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        PlayerColor color = new PlayerColor("white", "black");
        boolean isCheck = false;
        ReversiEngine instance = new ReversiEngine();
        boolean[] result = new boolean[8];
        for (int i = 0; i < 8; i++) {
            result[i] = false;
        }
        Position index = new Position(0, 0);
        assertArrayEquals(result, instance.checkallway(all, index, color, isCheck));
        for (int i = 0; i < 8; i++) {
            result[i] = false;
        }

        index.setSor(7);
        index.setOszlop(0);
        assertArrayEquals(result, instance.checkallway(all, index, color, isCheck));
        for (int i = 0; i < 8; i++) {
            result[i] = false;
        }

        index.setSor(7);
        index.setOszlop(7);
        assertArrayEquals(result, instance.checkallway(all, index, color, isCheck));

        index.setSor(0);
        index.setOszlop(7);
        for (int i = 0; i < 8; i++) {
            result[i] = false;
        }
        assertArrayEquals(result, instance.checkallway(all, index, color, isCheck));
    }

    /**
     * Test of allNull method, of class ReversiEngine.
     */
    @Test
    public void testAllNull() {
        boolean[] replacement = new boolean[8];
        ReversiEngine instance = new ReversiEngine();
        boolean[] expResult = new boolean[8];
        for (int i = 0; i < 8; i++) {
            replacement[i] = true;
        }
        assertArrayEquals(expResult, instance.allNull(replacement));
    }

    /**
     * Test of isreplacement method, of class ReversiEngine.
     */
    @Test
    public void testIsreplacement() {
        boolean[] replacement = new boolean[8];
        ReversiEngine instance = new ReversiEngine();
        for (int i = 0; i < 8; i++) {
            assertFalse(instance.isreplacement(replacement));
            replacement[i] = true;
            assertTrue(instance.isreplacement(replacement));
            replacement[i] = false;
        }

    }

    /**
     * Test of isEnd method, of class ReversiEngine.
     */
    @Test
    public void testIsEnd() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        all[7][7].setColor("");

        PlayerColor color = new PlayerColor("black", "white");
        ReversiEngine instance = new ReversiEngine();
        assertTrue(instance.isEnd(all, color));
        all[0][0].setColor("black");
        assertFalse(instance.isEnd(all, color));
    }

    /**
     * Test of isBusy method, of class ReversiEngine.
     */
    @Test
    public void testIsBusy() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        ReversiEngine instance = new ReversiEngine();
        assertTrue(instance.isBusy(all[2][2]));
        all[5][5].setColor("");
        assertFalse(instance.isBusy(all[5][5]));
    }

    /**
     * Test of colorOption method, of class ReversiEngine.
     */
    @Test
    public void testColorOption() {
        PlayerColor color = new PlayerColor("white", "black");
        PlayerColor colortest = new PlayerColor();
        int whoNext = 0;
        ReversiEngine instance = new ReversiEngine();
        instance.colorOption(colortest, whoNext);
        assertEquals(color, colortest);
        whoNext = 1;
        PlayerColor color1 = new PlayerColor("black", "white");
        instance.colorOption(colortest, whoNext);
        assertEquals(color1, colortest);
    }

    /**
     * Test of howManyBlackAndWhite method, of class ReversiEngine.
     */
    @Test
    public void testHowManyBlackAndWhite() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        ReversiEngine instance = new ReversiEngine();
        int[] result = new int[2];
        result[0] = 64;
        result[1] = 0;
        assertArrayEquals(result, instance.howManyBlackAndWhite(all));
    }

    /**
     * Test of whosNext method, of class ReversiEngine.
     */
    @Test
    public void testWhosNext() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        all[1][1].setColor("");
        ReversiEngine instance = new ReversiEngine();
        assertEquals(63, instance.whosNext(all));
    }

    /**
     * Test of whosWinner method, of class ReversiEngine.
     */
    @Test
    public void testWhosWinner() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        ReversiEngine instance = new ReversiEngine();
        assertEquals("white", instance.whosWinner(all));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j].setColor("black");
            }
        }
        assertEquals("black", instance.whosWinner(all));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j].setColor("black");
            }
        }
        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j].setColor("white");
            }
        }
        assertEquals("Tie", instance.whosWinner(all));

    }

    /**
     * Test of winnersPoints method, of class ReversiEngine.
     */
    @Test
    public void testWinnersPoints() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        ReversiEngine instance = new ReversiEngine();
        assertEquals(64, instance.winnersPoints(all));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j].setColor("black");
            }
        }
        assertEquals(64, instance.winnersPoints(all));
    }

    /**
     * Test of run method, of class ReversiEngine.
     */
    @Test
    public void testRun() {
        Cell[][] all = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j] = new Cell("white");
            }
        }
        Position index = new Position(2, 2);
        ReversiEngine instance = new ReversiEngine();
        instance.run(all, index);
        String message = "The place is already taken!";
        String message1 = "You can not place there";
        assertEquals(message, instance.getMessage());
        all[2][2].setColor("");
        instance.run(all, index);
        assertEquals(message1, instance.getMessage());
        all[3][3].setColor("black");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                all[i][j].setColor("white");
            }
        }
        all[2][2].setColor("");
        all[4][4].setColor("black");
        instance.run(all, index);
        assertEquals(64, instance.getNextPlayer());

    }

}
