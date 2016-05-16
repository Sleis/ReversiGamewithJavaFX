/* 
 * Copyright (C) 2016 Sleis
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Model;

import java.nio.file.Path;
import java.util.List;
import org.w3c.dom.Element;

/**
 *
 * @author Sleis
 */
public interface XMLManagerDao {

    public void createPlayers(Path path);

    public List<Element> readPlayers(Path path);

    public List<Element> sortPlayersByScore(List<Element> lista);

    public void addNewPlayer(Path path, Player jatekos);

}