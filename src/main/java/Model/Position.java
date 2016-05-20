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
 *
 * @author Iványi Dániel
 */
public class Position {
    private int sor;
    private int oszlop;

    public Position() {
    }
    
    public Position(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    public int getSor() {
        return sor;
    }

    public int getOszlop() {
        return oszlop;
    }

    public void setSor(int sor) {
        this.sor = sor;
    }

    public void setOszlop(int oszlop) {
        this.oszlop = oszlop;
    }
    
    
}
