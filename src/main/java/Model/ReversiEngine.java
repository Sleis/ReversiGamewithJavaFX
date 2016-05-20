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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A játék motorjának osztálya. A játékhoz tartozó összes funkciót tartalmazza.
 *
 * @author Iványi Dániel
 */
public class ReversiEngine {

    private static Logger logger = LoggerFactory.getLogger(ReversiEngine.class);
    /**
     * A játéknak a felhasználók számára szánt üzenete.
     */
    private String message;
    /**
     * A játékban a fekete és fehér körök számát tárolja.
     */
    private int[] BlackAndWhite;
    /**
     *Tárolja, hogy a játéknak vége van-e.
     */
    private boolean isEnd;
    /**
     *A játékban a következő játékos.
     */
    private int nextPlayer;
    
    /**
     * Létrehoz egy <code>ReversiEngine</code> objektumot.
     */
    public ReversiEngine() {
    }
    /**
     * Létrehoz egy <code>ReversiEngine</code> objektumot az adott paraméterű tulajdonságokkal.
     * 
     * @param message a játéknak a felhasználó számára szánt üzenete
     * @param BlackAndWhite a fekete és fehér körök száma
     * @param isEnd vége van-e a játéknak
     * @param nextPlayer következő játék
     */
    public ReversiEngine(String message, int[] BlackAndWhite, boolean isEnd, int nextPlayer) {
        this.message = message;
        this.BlackAndWhite = BlackAndWhite;
        this.isEnd = isEnd;
        this.nextPlayer = nextPlayer;
    }
    /**
     * Visszaadja a fekete és fehér körök számát. 
     * 
     * @return fekete és fehér körök száma
     */
    public int[] getBlackAndWhite() {
        return BlackAndWhite;
    }
    
    /**
     * Visszaadja, hogy vége van-e a játéknak.
     * 
     * @return játéknak vége van-e
     */
    public boolean isIsEnd() {
        return isEnd;
    }
    
    /**
     * Visszaadja a játéknak a felhasználó felé szánt üzenetét.
     * 
     * @return a játék üzenet a felhasználó felé
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Visszaadja a következő játékos számát.
     * 
     * @return a következő játékos  
     */
    public int getNextPlayer() {
        return nextPlayer;
    }
    
    /**
     * Beállítja a fekete és fehér körök számát.
     * 
     * @param BlackAndWhite fekete és fehér körök száma
     */
    public void setBlackAndWhite(int[] BlackAndWhite) {
        this.BlackAndWhite = BlackAndWhite;
    }
    
    /**
     * Beállítja, hogy vége van-e a játéknak.
     * 
     * @param isEnd a játéknak vége van-e
     */
    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    
    /**
     * Beállítja a játéknak a felhasználó számára szánt üzenetet.
     * 
     * @param message a játék üzenete a felhasználó számára
     */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Beállítja a következő játékost.
     * 
     * @param nextPlayer következő játékos
     */
    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }
    
    public boolean right(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor()][index.getOszlop() + 1].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor()][index.getOszlop() + 1].getColor().equals(color.getEnemyColor())) {

            for (int i = index.getOszlop() + 1; i < 8; i++) {
                if (all[index.getSor()][i].getColor().isEmpty()) {
                    return false;
                }
                if (all[index.getSor()][i].getColor().equals(color.getYourColor())) {
                    whereWasIt = i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = index.getOszlop() + 1; i < whereWasIt; i++) {
                    all[index.getSor()][i].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean up(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor() - 1][index.getOszlop()].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor() - 1][index.getOszlop()].getColor().equals(color.getEnemyColor())) {
            for (int i = index.getSor() - 1; i >= 0; i--) {
                if (all[i][index.getOszlop()].getColor().isEmpty()) {
                    return false;
                }
                if (all[i][index.getOszlop()].getColor().equals(color.getYourColor())) {
                    whereWasIt = i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = index.getSor() - 1; i > whereWasIt; i--) {
                    all[i][index.getOszlop()].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean down(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor() + 1][index.getOszlop()].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor() + 1][index.getOszlop()].getColor().equals(color.getEnemyColor())) {
            for (int i = index.getSor() + 1; i < 8; i++) {
                if (all[i][index.getOszlop()].getColor().isEmpty()) {
                    return false;
                }
                if (all[i][index.getOszlop()].getColor().equals(color.getYourColor())) {
                    whereWasIt = i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = index.getSor() + 1; i < whereWasIt; i++) {
                    all[i][index.getOszlop()].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean left(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor()][index.getOszlop() - 1].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor()][index.getOszlop() - 1].getColor().equals(color.getEnemyColor())) {
            for (int i = index.getOszlop() - 1; i >= 0; i--) {
                if (all[index.getSor()][i].getColor().isEmpty()) {
                    return false;
                }
                if (all[index.getSor()][i].getColor().equals(color.getYourColor())) {
                    whereWasIt = i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = index.getOszlop() - 1; i > whereWasIt; i--) {
                    all[index.getSor()][i].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean upandleft(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor() - 1][index.getOszlop() - 1].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor() - 1][index.getOszlop() - 1].getColor().equals(color.getEnemyColor())) {
            for (int i = 1; i <= Math.min(index.getOszlop(), index.getSor()); i++) {
                if (all[index.getSor() - i][index.getOszlop() - i].getColor().isEmpty()) {
                    return false;
                }
                if (all[index.getSor() - i][index.getOszlop() - i].getColor().equals(color.getYourColor())) {
                    whereWasIt = index.getSor() - i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = 1; i <= index.getSor() - whereWasIt; i++) {
                    all[index.getSor() - i][index.getOszlop() - i].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean upandright(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor() - 1][index.getOszlop() + 1].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor() - 1][index.getOszlop() + 1].getColor().equals(color.getEnemyColor())) {
            for (int i = 1; i < Math.min(8 - index.getOszlop(), index.getSor() + 1); i++) {
                if (all[index.getSor() - i][index.getOszlop() + i].getColor().isEmpty()) {
                    return false;
                }
                if (all[index.getSor() - i][index.getOszlop() + i].getColor().equals(color.getYourColor())) {
                    whereWasIt = index.getSor() - i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = 1; i <= index.getSor() - whereWasIt; i++) {
                    all[index.getSor() - i][index.getOszlop() + i].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean downandleft(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor() + 1][index.getOszlop() - 1].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor() + 1][index.getOszlop() - 1].getColor().equals(color.getEnemyColor())) {
            for (int i = 1; i < Math.min(index.getOszlop() + 1, 8 - index.getSor()); i++) {
                if (all[index.getSor() + i][index.getOszlop() - i].getColor().isEmpty()) {
                    return false;
                }
                if (all[index.getSor() + i][index.getOszlop() - i].getColor().equals(color.getYourColor())) {
                    whereWasIt = index.getOszlop() - i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = 1; i <= index.getOszlop() - whereWasIt; i++) {
                    all[index.getSor() + i][index.getOszlop() - i].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean downandright(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean isThere = false;
        int whereWasIt = -1;
        if (all[index.getSor() + 1][index.getOszlop() + 1].getColor().isEmpty()) {
            return false;
        }
        if (all[index.getSor() + 1][index.getOszlop() + 1].getColor().equals(color.getEnemyColor())) {
            for (int i = 1; i < Math.min(8 - index.getOszlop(), 8 - index.getSor()); i++) {
                if (all[index.getSor() + i][index.getOszlop() + i].getColor().isEmpty()) {
                    return false;
                }
                if (all[index.getSor() + i][index.getOszlop() + i].getColor().equals(color.getYourColor())) {
                    whereWasIt = index.getOszlop() + i;
                    isThere = true;
                    break;
                }
            }
        } else {
            return false;
        }

        if (isThere) {
            if (!isCheck) {
                for (int i = 1; i <= whereWasIt - index.getOszlop(); i++) {
                    all[index.getSor() + i][index.getOszlop() + i].setColor(color.getYourColor());
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public boolean[] checkallway(Cell[][] all, Position index, PlayerColor color, boolean isCheck) {
        boolean[] tmp = new boolean[8];
        if (index.getOszlop() != 7) {
            tmp[0] = right(all, index, color, isCheck);
        }
        if (index.getSor() != 0) {
            tmp[1] = up(all, index, color, isCheck);
        }
        if (index.getOszlop() != 0) {
            tmp[2] = left(all, index, color, isCheck);
        }
        if (index.getSor() != 7) {
            tmp[3] = down(all, index, color, isCheck);
        }
        if (index.getSor() != 0 && index.getOszlop() != 0) {
            tmp[4] = upandleft(all, index, color, isCheck);
        }
        if (index.getSor() != 0 && index.getOszlop() != 7) {
            tmp[5] = upandright(all, index, color, isCheck);
        }
        if (index.getSor() != 7 && index.getOszlop() != 0) {
            tmp[6] = downandleft(all, index, color, isCheck);
        }
        if (index.getSor() != 7 && index.getOszlop() != 7) {
            tmp[7] = downandright(all, index, color, isCheck);
        }
        return tmp;
    }

    public boolean[] allNull(boolean[] replacement) {
        for (int i = 0; i < replacement.length; i++) {
            replacement[i] = false;
        }
        return replacement;
    }

    public boolean isreplacement(boolean[] replacement) {
        return replacement[0] || replacement[1] || replacement[2] || replacement[3] || replacement[4] || replacement[5] || replacement[6] || replacement[7];
    }

    public boolean isEnd(Cell[][] all, PlayerColor color) {
        boolean[] replacement = new boolean[8];
        int counter = 0;
        Position index = new Position();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                allNull(replacement);
                index.setSor(i);
                index.setOszlop(j);
                if (!all[index.getSor()][index.getOszlop()].getColor().isEmpty()) {
                    counter++;
                } else {
                    replacement = checkallway(all, index, color, true);
                    if (!isreplacement(replacement)) {
                        counter++;
                    }
                }
            }
        }
        return counter == 64;
    }

    public boolean isBusy(Cell cell) {
        return !cell.getColor().equals("");
    }

    public void colorOption(PlayerColor color, int whoNext) {
        if (whoNext % 2 == 0) {
            color.setYourColor("white");
            color.setEnemyColor("black");
        } else {
            color.setYourColor("black");
            color.setEnemyColor("white");
        }
    }

    public int[] howManyBlackAndWhite(Cell[][] allCell) {
        int[] color = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (allCell[i][j].getColor().equals("white")) {
                    color[0]++;
                }
                if (allCell[i][j].getColor().equals("black")) {
                    color[1]++;
                }
            }
        }
        return color;
    }

    public int whosNext(Cell[][] allCell) {
        int whosNextTmp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!allCell[i][j].getColor().isEmpty()) {
                    whosNextTmp++;
                }
            }
        }
        return whosNextTmp;
    }

    public String whosWinner(Cell[][] allCell) {
        String whosWinnerTmp;
        int[] whosWon = howManyBlackAndWhite(allCell);
        if (whosWon[0] > whosWon[1]) {
            whosWinnerTmp = "white";
        } else if (whosWon[0] < whosWon[1]) {
            whosWinnerTmp = "black";
        } else {
            whosWinnerTmp = "Tie";
        }
        return whosWinnerTmp;
    }

    public int winnersPoints(Cell[][] allCell) {
        int tmp;
        String winner = whosWinner(allCell);
        int[] points = howManyBlackAndWhite(allCell);
        if (points[0] > points[1]) {
            tmp = 64 - points[1];
        } else {
            tmp = 64 - points[0];
        }
        return tmp;
    }

    public void run(Cell[][] allCell, Position index) {
        logger.info("A run függvény meghívódott");
        PlayerColor color = new PlayerColor();
        PlayerColor otherColor = new PlayerColor();
        boolean[] replacement = new boolean[8];
        this.nextPlayer = whosNext(allCell);
        allNull(replacement);
        if (this.isBusy(allCell[index.getSor()][index.getOszlop()])) {
            logger.info("A hely foglalt, ahova rakni akartál");
            this.message = "The place is already taken!";
        } else {
            colorOption(color, this.nextPlayer);
            replacement = checkallway(allCell, index, color, false);
            if (isreplacement(replacement)) {
                allCell[index.getSor()][index.getOszlop()].setColor(color.getYourColor());
                this.nextPlayer++;
            } else {
                logger.info("Oda nem rakhatsz");
                this.message = "You can not place there";
            }

            allNull(replacement);

            colorOption(otherColor, this.nextPlayer);

            this.isEnd = isEnd(allCell, otherColor);

        }

        this.BlackAndWhite = howManyBlackAndWhite(allCell);

    }

}
