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
     * Tárolja, hogy a játéknak vége van-e.
     */
    private boolean isEnd;
    /**
     * A játékban a következő játékos.
     */
    private int nextPlayer;

    /**
     * Létrehoz egy <code>ReversiEngine</code> objektumot.
     */
    public ReversiEngine() {
    }

    /**
     * Létrehoz egy <code>ReversiEngine</code> objektumot az adott paraméterű
     * tulajdonságokkal.
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve jobbra az első cella
     * üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz, akkor megnézi,
     * hogy ugyanebben a cellában az ellenfél szinével megegyező szinű kör
     * van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig megy a
     * <code>index</code> poziciótól jobbra lévő cellákon, ameddig nem talál
     * vagy üres vagy a soron következő játékossal megegyező szinű kört. Ha üres
     * cellát talált, akkor visszatér hamis értékkel, ha megfelelő szinű kört
     * talált, akkor megjegyzi az adott oszlopszámot a <code>whereWasIt</code>
     * változóban és eltárol igaz értéket az <code>isThere</code> változóban. Ha
     * az <code>isThere</code> változó igaz, akkor megnézi, hogy
     * <code>isCheck</code> paraméter igaz-e, ha hamis, akkor végig megy a
     * <code>index</code> pozíciótól jobbra addig amíg nem éri el
     * <code>whereWasIt</code> változóban tárolt oszlopszámot és az összes kör
     * szinét kicseréli az aktuális játékos szinével megegyező szinre és
     * visszatér igaz értékkel. Ha az <code>isCheck</code> paraméter igaz, akkor
     * nem történik semmi, csak visszatér igaz értékkel. Ha az
     * <code>isThere</code> változó hamis, akkor hamis értékkel visszatér a
     * függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve felfele az első cella
     * üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz, akkor megnézi,
     * hogy ugyanebben a cellában az ellenfél szinével megegyező szinű kör
     * van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig megy a
     * <code>index</code> poziciótól felfele lévő cellákon, ameddig nem talál
     * vagy üres vagy a soron következő játékossal megegyező szinű kört. Ha üres
     * cellát talált, akkor visszatér hamis értékkel, ha megfelelő szinű kört
     * talált, akkor megjegyzi az adott sorszámot a <code>whereWasIt</code>
     * változóban és eltárol igaz értéket az <code>isThere</code> változóban. Ha
     * az <code>isThere</code> változó igaz, akkor megnézi, hogy
     * <code>isCheck</code> paraméter igaz-e, ha hamis, akkor végig megy a
     * <code>index</code> pozíciótól felfele addig amíg nem éri el
     * <code>whereWasIt</code> változóban tárolt sorszámot és az összes kör
     * szinét kicseréli az aktuális játékos szinével megegyező szinre és
     * visszatér igaz értékkel. Ha az <code>isCheck</code> paraméter igaz, akkor
     * nem történik semmi, csak visszatér igaz értékkel. Ha az
     * <code>isThere</code> változó hamis, akkor hamis értékkel visszatér a
     * függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve lefele az első cella
     * üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz, akkor megnézi,
     * hogy ugyanebben a cellában az ellenfél szinével megegyező szinű kör
     * van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig megy a
     * <code>index</code> poziciótól lefele lévő cellákon, ameddig nem talál
     * vagy üres vagy a soron következő játékossal megegyező szinű kört. Ha üres
     * cellát talált, akkor visszatér hamis értékkel, ha megfelelő szinű kört
     * talált, akkor megjegyzi az adott sorszámot a <code>whereWasIt</code>
     * változóban és eltárol igaz értéket az <code>isThere</code> változóban. Ha
     * az <code>isThere</code> változó igaz, akkor megnézi, hogy
     * <code>isCheck</code> paraméter igaz-e, ha hamis, akkor végig megy a
     * <code>index</code> pozíciótól lefele addig amíg nem éri el
     * <code>whereWasIt</code> változóban tárolt sorszámot és az összes kör
     * szinét kicseréli az aktuális játékos szinével megegyező szinre és
     * visszatér igaz értékkel. Ha az <code>isCheck</code> paraméter igaz, akkor
     * nem történik semmi, csak visszatér igaz értékkel. Ha az
     * <code>isThere</code> változó hamis, akkor hamis értékkel visszatér a
     * függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve balra az első cella
     * üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz, akkor megnézi,
     * hogy ugyanebben a cellában az ellenfél szinével megegyező szinű kör
     * van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig megy a
     * <code>index</code> poziciótól balra lévő cellákon, ameddig nem talál vagy
     * üres vagy a soron következő játékossal megegyező szinű kört. Ha üres
     * cellát talált, akkor visszatér hamis értékkel, ha megfelelő szinű kört
     * talált, akkor megjegyzi az adott oszlopszámot a <code>whereWasIt</code>
     * változóban és eltárol igaz értéket az <code>isThere</code> változóban. Ha
     * az <code>isThere</code> változó igaz, akkor megnézi, hogy
     * <code>isCheck</code> paraméter igaz-e, ha hamis, akkor végig megy a
     * <code>index</code> pozíciótól balra addig amíg nem éri el
     * <code>whereWasIt</code> változóban tárolt oszlopszámot és az összes kör
     * szinét kicseréli az aktuális játékos szinével megegyező szinre és
     * visszatér igaz értékkel. Ha az <code>isCheck</code> paraméter igaz, akkor
     * nem történik semmi, csak visszatér igaz értékkel. Ha az
     * <code>isThere</code> változó hamis, akkor hamis értékkel visszatér a
     * függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve balfelső átlóban az
     * első cella üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz,
     * akkor megnézi, hogy ugyanebben a cellában az ellenfél szinével megegyező
     * szinű kör van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig
     * megy a <code>index</code> poziciótól balfelső átlóban lévő cellákon,
     * ameddig nem talál vagy üres vagy a soron következő játékossal megegyező
     * szinű kört. Ha üres cellát talált, akkor visszatér hamis értékkel, ha
     * megfelelő szinű kört talált, akkor megjegyzi az adott sorszámot a
     * <code>whereWasIt</code> változóban és eltárol igaz értéket az
     * <code>isThere</code> változóban. Ha az <code>isThere</code> változó igaz,
     * akkor megnézi, hogy <code>isCheck</code> paraméter igaz-e, ha hamis,
     * akkor végig megy a <code>index</code> pozíciótól balfelfele lévő átlón
     * addig amíg nem éri el <code>whereWasIt</code> változóban tárolt sorszámot
     * és az összes kör szinét kicseréli az aktuális játékos szinével megegyező
     * szinre és visszatér igaz értékkel. Ha az <code>isCheck</code> paraméter
     * igaz, akkor nem történik semmi, csak visszatér igaz értékkel. Ha az
     * <code>isThere</code> változó hamis, akkor hamis értékkel visszatér a
     * függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve jobbfelső átlóban az
     * első cella üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz,
     * akkor megnézi, hogy ugyanebben a cellában az ellenfél szinével megegyező
     * szinű kör van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig
     * megy a <code>index</code> poziciótól jobbfelső átlóban lévő cellákon,
     * ameddig nem talál vagy üres vagy a soron következő játékossal megegyező
     * szinű kört. Ha üres cellát talált, akkor visszatér hamis értékkel, ha
     * megfelelő szinű kört talált, akkor megjegyzi az adott sorszámot a
     * <code>whereWasIt</code> változóban és eltárol igaz értéket az
     * <code>isThere</code> változóban. Ha az <code>isThere</code> változó igaz,
     * akkor megnézi, hogy <code>isCheck</code> paraméter igaz-e, ha hamis,
     * akkor végig megy a <code>index</code> pozíciótól jobbfelfele lévő átlón
     * addig amíg nem éri el <code>whereWasIt</code> változóban tárolt sorszámot
     * és az összes kör szinét kicseréli az aktuális játékos szinével megegyező
     * szinre és visszatér igaz értékkel. Ha az <code>isCheck</code> paraméter
     * igaz, akkor nem történik semmi, csak visszatér igaz értékkel. Ha az
     * <code>isThere</code> változó hamis, akkor hamis értékkel visszatér a
     * függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve balalsó átlóban az
     * első cella üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz,
     * akkor megnézi, hogy ugyanebben a cellában az ellenfél szinével megegyező
     * szinű kör van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig
     * megy a <code>index</code> poziciótól balalsó átlóban lévő cellákon,
     * ameddig nem talál vagy üres vagy a soron következő játékossal megegyező
     * szinű kört. Ha üres cellát talált, akkor visszatér hamis értékkel, ha
     * megfelelő szinű kört talált, akkor megjegyzi az adott oszlopszámot a
     * <code>whereWasIt</code> változóban és eltárol igaz értéket az
     * <code>isThere</code> változóban. Ha az <code>isThere</code> változó igaz,
     * akkor megnézi, hogy <code>isCheck</code> paraméter igaz-e, ha hamis,
     * akkor végig megy a <code>index</code> pozíciótól ballefele lévő átlón
     * addig amíg nem éri el <code>whereWasIt</code> változóban tárolt
     * oszlopszámot és az összes kör szinét kicseréli az aktuális játékos
     * szinével megegyező szinre és visszatér igaz értékkel. Ha az
     * <code>isCheck</code> paraméter igaz, akkor nem történik semmi, csak
     * visszatér igaz értékkel. Ha az <code>isThere</code> változó hamis, akkor
     * hamis értékkel visszatér a függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Megnézi, hogy a <code>index</code> pozíciótól nézve jobbalsó átlóban az
     * első cella üres-e, ha üres, akkor visszatér hamis értékkel. Ha igaz,
     * akkor megnézi, hogy ugyanebben a cellában az ellenfél szinével megegyező
     * szinű kör van-e. Ha nem, akkor visszatér hamis értékkel, egyébként végig
     * megy a <code>index</code> poziciótól jobbalsó átlóban lévő cellákon,
     * ameddig nem talál vagy üres vagy a soron következő játékossal megegyező
     * szinű kört. Ha üres cellát talált, akkor visszatér hamis értékkel, ha
     * megfelelő szinű kört talált, akkor megjegyzi az adott oszlopszámot a
     * <code>whereWasIt</code> változóban és eltárol igaz értéket az
     * <code>isThere</code> változóban. Ha az <code>isThere</code> változó igaz,
     * akkor megnézi, hogy <code>isCheck</code> paraméter igaz-e, ha hamis,
     * akkor végig megy a <code>index</code> pozíciótól jobblefele lévő átlón
     * addig amíg nem éri el <code>whereWasIt</code> változóban tárolt
     * oszlopszámot és az összes kör szinét kicseréli az aktuális játékos
     * szinével megegyező szinre és visszatér igaz értékkel. Ha az
     * <code>isCheck</code> paraméter igaz, akkor nem történik semmi, csak
     * visszatér igaz értékkel. Ha az <code>isThere</code> változó hamis, akkor
     * hamis értékkel visszatér a függvény.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova kört akarunk rakni
     * @param color a soron következő játékos és az ellenfél játékos szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     *
     * @return igaz, ha szabályos lépés kört rakni az <code>index</code>
     * pozícióba, egyébként hamis
     */
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

    /**
     * Leellenörzi, hogy az adott <code>index</code> pozícióból nézve, az összes
     * irányt tekintve szabályos lépés-e, ha ide rakunk kört. Ha legalább egy
     * irányba nézve szabályos lépés ide rakni a kört, akkor igazat ad vissza,
     * egyébként hamisat.Az ellenörzés a {@link ReversiEngine#down(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)} ,
     * {@link ReversiEngine#up(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)},
     * {@link ReversiEngine#right(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)},
     * {@link ReversiEngine#left(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)},
     * {@link ReversiEngine#downandleft(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)},
     * {@link ReversiEngine#downandright(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)},
     * {@link ReversiEngine#upandleft(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)}
     * és
     * {@link ReversiEngine#upandright(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)}
     * metódusok segítségével történik.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     * @param index a pozició, ahova akarjuk rakni a körünket
     * @param color a soron következő játékos és az ellenfél szine
     * @param isCheck megmondja, hogy ellenörzünk vagy szinváltást is fogunk
     * végezni
     * @return igaz, ha szabályos lépés oda rakni, egyébként hamis
     */
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

    /**
     * Beállítja a <code>replacement</code> összes elemét hamisra.
     *
     * @param replacement boolean tömb
     * @return tömb, aminek az összes eleme hamis
     */
    public boolean[] allNull(boolean[] replacement) {
        for (int i = 0; i < replacement.length; i++) {
            replacement[i] = false;
        }
        return replacement;
    }

    /**
     * Leellenörzi, hogy a <code>replacement</code> tömbben van-e igaz érték.
     *
     * @param replacement tömb, ami tárolja, hogy melyik irányra nézve volt
     * szabályos lépés
     *
     * @return igaz, ha volt szabályos lépés, egyébként hamis
     */
    public boolean isreplacement(boolean[] replacement) {
        return replacement[0] || replacement[1] || replacement[2] || replacement[3] || replacement[4] || replacement[5] || replacement[6] || replacement[7];
    }

    /**
     * Leellenörzi, hogy a játéknak vége van-e az alapján, hogy tele van-e a
     * tábla vagy van-e még szabályos lépés. A szabályos lépés ellenörzése a {@link ReversiEngine#checkallway(Model.Cell[][], Model.Position, Model.PlayerColor, boolean)
     * } metódus segítségével történik. Összesen 64 hely van, végig megyünk az
     * összes cellán, ha az adott cellában van kör vagy az adott helyre nem
     * szabályos tenni, akkor növeljük a változót. Ha a változó a végén 64,
     * akkor vége van és igazat ad vissza, egyébként hamisat.
     *
     * @param all a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     * @param color a soron következő játékos és az ellenfél szine
     * @return igaz, ha vége van egyébként hamis
     */
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

    /**
     * Leellenörzi, hogy a <code>cell</code> cellában van-e kör, ha van igaz,
     * egyébként hamis.
     *
     * @param cell egy cella a pályából
     * @return igaz, ha foglalt egybként hamis
     */
    public boolean isBusy(Cell cell) {
        return !cell.getColor().equals("");
    }

    /**
     * Beállítja a <code>color</code> paramétert, hogy a soron következő
     * játékosnak mi a szine és az ellenfélnek mi a szine.
     *
     * @param color aminek a tulajdonságait állítjuk át
     * @param whoNext megadja, hogy ki a következő
     */
    public void colorOption(PlayerColor color, int whoNext) {
        if (whoNext == 0) {
            color.setYourColor("white");
            color.setEnemyColor("black");
        } else {
            color.setYourColor("black");
            color.setEnemyColor("white");
        }
    }

    /**
     * Megszámolja és visszaadja, hogy összesen hány fekete és fehér kör van a
     * pályán.
     *
     * @param allCell a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @return visszaadja, hogy mennyi fekete és fehér kör van
     */
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

    /**
     * Kiszámolja, hogy ki a következő az alapján, hogy hány kör van a pályán.
     *
     * @param allCell a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @return a következő játákos száma
     */
    public int whosNext(Cell[][] allCell) {
        int whosNextTmp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!allCell[i][j].getColor().isEmpty()) {
                    whosNextTmp++;
                }
            }
        }
        return whosNextTmp % 2;
    }

    /**
     * Kiszámolja, hogy ki a győztes az alapján, hogy kinek hány körje van a
     * pályán, amit a {@link ReversiEngine#howManyBlackAndWhite(Model.Cell[][])
     * } metódus segítségével történik.
     *
     * @param allCell a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @return a győztes játékos szine
     */
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

    /**
     * Kiszámolja, hogy a győztesnek hány pontja van. Pont számítása:
     * összeshely(64) - ellenfél pontszáma.
     *
     * @param allCell a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @return a győztes pontszáma
     */
    public int winnersPoints(Cell[][] allCell) {
        int tmp;
        int[] points = howManyBlackAndWhite(allCell);
        if (points[0] > points[1]) {
            tmp = 64 - points[1];
        } else {
            tmp = 64 - points[0];
        }
        return tmp;
    }

    /**
     * A játék menetét hajtja végre. Elsőnek kiszámolja,hogy ki a következő játékos
     * a {@link ReversiEngine#whosNext(Model.Cell[][])} metódussal. Megnézi,
     * hogy a <code>index</code> pozícióban van-e kör, ha van akkor beállítja
     * {@link ReversiEngine#message} tulajdonságot, hogy a hely foglalt.Ha nem
     * foglalt, akkor beállítja a <code>color</code> változót megfelelően a {@link ReversiEngine#colorOption(Model.PlayerColor, int)
     * } metódus segítségével. Azután leellenörzi, hogy szabályos lépés-e oda
     * rakni a kört. Ha szabályos akkor, berakja a soron következő játékos
     * szinével megegyező kört az <code>index</code> pozícióba. Ha nem szabályos
     * lépés oda rakni, akkor a {@link ReversiEngine#message} tulajdonságot
     * beállítja, hogy oda nem lehet rakni. Majd beállítja a
     * <code>otherColor</code> változót a megfelelően a {@link ReversiEngine#colorOption(Model.PlayerColor, int)
     * } metódus segítségével és leellenörzi a {@link ReversiEngine#isEnd(Model.Cell[][], Model.PlayerColor)
     * } metódus segítségével, hogy vége van-e a játéknak, ezt az értéket fogja
     * tárolni a {@link ReversiEngine#isEnd} tulajdonsága az objektumnak.A végén
     * pedig a {@link ReversiEngine#BlackAndWhite} tulajdonságban eltároljuk {@link ReversiEngine#howManyBlackAndWhite(Model.Cell[][])
     * } metódus segítségével, hogy mennyi fekete és fehér kör van a pályán.
     *
     * @param allCell a játék pályája, ami tartalmazza melyik pozícióban, milyen
     * szinű kör van
     *
     * @param index a pozíció, ahova rakni akarjuk a kört
     */
    public void run(Cell[][] allCell, Position index) {
        logger.debug("Meghívódott a ReversiEngine run metódusa.");
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
                this.nextPlayer = (this.nextPlayer + 1) % 2;
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
