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
 *
 * @author Sleis
 */
public class Player {
    private String name;
    private int points;
    private LocalDate date;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    
}
