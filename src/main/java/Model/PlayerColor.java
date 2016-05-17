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

import java.util.Objects;

/**
 *
 * @author Sleis
 */
public class PlayerColor {
    private String yourColor;
    private String enemyColor;

    public PlayerColor() {
    }
    

    public PlayerColor(String yourColor, String enemyColor) {
        this.yourColor = yourColor;
        this.enemyColor = enemyColor;
    }

    public String getYourColor() {
        return yourColor;
    }

    public String getEnemyColor() {
        return enemyColor;
    }

    public void setYourColor(String yourColor) {
        this.yourColor = yourColor;
    }

    public void setEnemyColor(String enemyColor) {
        this.enemyColor = enemyColor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlayerColor other = (PlayerColor) obj;
        if (!Objects.equals(this.yourColor, other.yourColor)) {
            return false;
        }
        if (!Objects.equals(this.enemyColor, other.enemyColor)) {
            return false;
        }
        return true;
    }
    
    
}
