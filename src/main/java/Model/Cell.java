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
 * A cellák típúsának osztálya
 *
 * @author Iványi Dániel
 */
public class Cell {
    
    /**
     * A cellához tartozó szint tárolja.
     */
    private String color;

    /**
     * Létrehoz egy <code>Cell</code> objektumot üres <code>color</code> tulajdonsággal.
     */
    
    public Cell() {
        this.color = "";
    }
    
    /**
     * Létrehoz egy <code>Cell</code> objektumot adott szinű tulajdonsággal.
     * @param color az objektum <code>color</code> tulajdonsága
     */
    public Cell(String color) {
        this.color = color;
    }
    
    /**
     * Visszaadja az objektum <code>color</code> color tulajdonságát.
     * @return az objektum <code>color</code> tulajdonsága
     */
    public String getColor() {
        return color;
    }
    /**
     * Beállítja az objektum <code>color</code> tulajdonságát.
     * @param color az objektum <code>color</code> tulajdonsága
     */
    
    public void setColor(String color) {
        this.color = color;
    }

}
