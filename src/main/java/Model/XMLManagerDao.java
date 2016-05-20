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
import java.nio.file.Path;
import java.util.List;
import org.w3c.dom.Element;

/**
 * Az osztály az XML fájlon végezhető műveleteket definiálja.
 *
 * @author Iványi Dániel
 */
public interface XMLManagerDao {

    /**
     * Létrehozza a <code>path</code> útvonalon a players.xml fájlt.
     *
     * @param path az útvonal, ahol létrehozzuk az XML fájlt
     */
    public void createPlayers(Path path);

    /**
     * Visszaadja a listát, ami az XML fájlban lévő adatokat tartalmazza.
     *
     * @param path az XML fájl elérési útvonala
     *
     * @return egy lista, ami az XML fájlból kiolvasott adatokat tartalmazza
     */
    public List<Element> readPlayers(Path path);

    /**
     * Visszaad egy listát, amiben a <code>lista</code> elemei rendezve vannak
     * pontszám szerint.
     *
     * @param lista egy lista a játékosok adataival
     *
     * @return egy lista amiben a <code>lista</code> elemei rendezve vannak
     * pontszám szerint
     */
    public List<Element> sortPlayersByScore(List<Element> lista);

    /**
     * Hozzáad egy új játékost az XML fájlhoz.
     *
     * @param path az XML fájl elérési útvonala
     *
     * @param jatekos a játékos adatai, amit az XML fájlhoz adunk
     */
    public void addNewPlayer(Path path, Player jatekos);

}
