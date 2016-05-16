/*
 * Copyright (C) 2016 University of Debrecen, Faculty of Informatics
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

import com.sun.org.apache.xerces.internal.dom.NodeImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sleis
 */
public class XMLManagerDaoImpTest {

    /**
     * Test of createPlayers method, of class XMLManagerDaoImp.
     */
    @Test
    public void testCreatePlayers() {
        XMLManagerDaoImp instance = new XMLManagerDaoImp();
        Path p = Paths.get(System.getProperty("user.home"), "Documents", "Reversi", "teszt.xml");
        if (!p.toFile().isFile()) {
            Path dir = Paths.get(System.getProperty("user.home"), "Documents", "Reversi");
            dir.toFile().mkdirs();
            instance.createPlayers(p);
        }
        assertTrue(p.toFile().isFile());
        File file = new File(p.toString());
        file.delete();

    }

    /**
     * Test of readPlayers method, of class XMLManagerDaoImp.
     *
     * @throws org.xml.sax.SAXException
     */
    @Test
    public void testReadPlayers() throws SAXException {
        XMLManagerDaoImp instance = new XMLManagerDaoImp();
        Path p = Paths.get(System.getProperty("user.home"), "Documents", "Reversi", "teszt.xml");
        if (!p.toFile().isFile()) {
            Path dir = Paths.get(System.getProperty("user.home"), "Documents", "Reversi");
            dir.toFile().mkdirs();
            instance.createPlayers(p);

        }
        Player test = new Player("Dani", 10);
        instance.addNewPlayer(p, test);
        List<Element> list = instance.readPlayers(p);
        test.setName("Dani");
        test.setPoints(10);
        test.setDate(LocalDate.parse(list.get(0).getElementsByTagName("date").item(0).getTextContent()));
        assertEquals(test.getName(), list.get(0).getElementsByTagName("name").item(0).getTextContent());
        assertEquals(test.getPoints(), Integer.parseInt(list.get(0).getElementsByTagName("points").item(0).getTextContent()));
        assertEquals(test.getLocalDate(), LocalDate.parse(list.get(0).getElementsByTagName("date").item(0).getTextContent()));
        File file;
        file = p.toFile();
        file.delete();
    }

    /**
     * Test of sortPlayersByScore method, of class XMLManagerDaoImp.
     */
    @Test
    public void testSortPlayersByScore() {
        XMLManagerDaoImp instance = new XMLManagerDaoImp();
        Path p = Paths.get(System.getProperty("user.home"), "Documents", "Reversi", "teszt.xml");
        if (!p.toFile().isFile()) {
            Path dir = Paths.get(System.getProperty("user.home"), "Documents", "Reversi");
            dir.toFile().mkdirs();
            instance.createPlayers(p);
        }
        Player test1 = new Player("Dani", 10);
        Player test2 = new Player("Pisti", 8);
        Player test3 = new Player("Gábor", 12);
        instance.addNewPlayer(p, test1);
        instance.addNewPlayer(p, test2);
        instance.addNewPlayer(p, test3);
        List<Element> list = instance.readPlayers(p);
        list = instance.sortPlayersByScore(list);
        assertEquals("Gábor", list.get(0).getElementsByTagName("name").item(0).getTextContent());
        assertEquals(12, list.get(0).getElementsByTagName("poins").item(0).getTextContent());
        File file = p.toFile();
        file.delete();

    }

    /**
     * Test of addNewPlayer method, of class XMLManagerDaoImp.
     */
    @Test
    public void testAddNewPlayer() {

    }

}
