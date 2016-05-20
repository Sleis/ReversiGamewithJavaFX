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
/**
 * Adott cella pozíciót tartalmazó osztály.
 *
 * @author Iványi Dániel
 */
public class Position {

    /**
     * A cella sorszáma.
     */
    private int sor;
    /**
     * A cella oszlopszáma.
     */
    private int oszlop;

    /**
     * Létrehoz egy <code>Position</code> objektumot üres <code>sor</code> és
     * <code>oszlop</code> tulajdonsággal.
     */
    public Position() {
    }

    /**
     * Létrehoz egy <code>Position</code> objektumot adott <code>sor</code> és
     * <code>oszlop</code> tulajdonsággal.
     *
     * @param sor az objektum <code>sor</code> tulajdonsága
     * @param oszlop az objektum <code>oszlop</code> tulajdonsága
     */
    public Position(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    /**
     * Visszaadja az objektum <code>sor</code> tulajdonságát.
     *
     * @return az objektum <code>sor</code> tulajdonsága
     */
    public int getSor() {
        return sor;
    }

    /**
     * Visszaadja az objektum <code>oszlop</code> tulajdonságát.
     *
     * @return az objektum <code>oszlop</code> tulajdonsága
     */
    public int getOszlop() {
        return oszlop;
    }

    /**
     * Beállítja az objektum <code>sor</code> tulajdonságát.
     *
     * @param sor az objektum <code>sor</code> tulajdonsága
     */
    public void setSor(int sor) {
        this.sor = sor;
    }

    /**
     * Beállítja az objektum <code>oszlop</code> tulajdonságát.
     *
     * @param oszlop az objektum <code>oszlop</code> tulajdonsága
     */
    public void setOszlop(int oszlop) {
        this.oszlop = oszlop;
    }

}
