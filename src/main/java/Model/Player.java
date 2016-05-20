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

/**
 * A játékosok tulajdonságait tartalmazó osztály.
 *
 * @author Iványi Dániel
 */
public class Player {

    /**
     * A játékos neve.
     */
    private String name;
    /**
     * A játékos pontja.
     */
    private int points;
    /**
     * A játékos által játszott játék ideje.
     */
    private LocalDate date;

    /**
     * Létrehoz egy <code>Player</code> objektumot <code>name</code> ,
     * <code>points</code> tulajdonsággal és az aktuális idővel.
     *
     * @param name a játékos neve
     *
     * @param points a játékos pontszáma
     */
    public Player(String name, int points) {
        this.name = name;
        this.points = points;
        this.date = LocalDate.now();
    }

    /**
     * Visszaadja a játékos <code>name</code> tulajdonságát.
     *
     * @return az objektum <code>name</code> tulajdonsága
     */
    public String getName() {
        return name;
    }

    /**
     * Visszaadja a játékos <code>points</code> tulajdonságát.
     *
     * @return az objektum <code>points</code> tulajdonsága
     */
    public int getPoints() {
        return points;
    }

    /**
     * Visszaadja a játékos <code>date</code> tulajdonságát.
     *
     * @return az objektum <code>date</code> tulajdonsága
     */
    public LocalDate getLocalDate() {
        return date;
    }

    /**
     * Beállítja az objektum <code>name</code> tulajdonságát.
     *
     * @param name az objektum <code>name</code> tulajdonsága
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Beállítja az objektum <code>points</code> tulajdonságát.
     *
     * @param points az objektum <code>points</code> tulajdonsága
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Beállítja az objektum <code>date</code> tulajdonságát.
     *
     * @param date az objektum <code>date</code> tulajdonsága
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
