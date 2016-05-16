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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sleis
 */
public class XMLManagerDaoImp implements XMLManagerDao {

    private static Logger logger = LoggerFactory.getLogger(XMLManagerDaoImp.class);
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;

    static {
        factory = DocumentBuilderFactory.newInstance();

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            logger.error("ParserConfigurationException");
        }

    }

    @Override
    public void createPlayers(Path path) {
        try {
            Document doc = builder.newDocument();
            Element gyoker = doc.createElement("players");
            doc.appendChild(gyoker);

            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();
            DOMSource domForras = new DOMSource(doc);
            StreamResult ujFajl = new StreamResult(path.toFile());
            trans.transform(domForras, ujFajl);

        } catch (TransformerException ex) {
            logger.error("TransformerException");
        }

    }

    @Override
    public List<Element> readPlayers(Path path) {
        try {
            File file = path.toFile();
            Document doc = builder.parse(file);
            NodeList nodeLista = doc.getElementsByTagName("player");
            List<Element> elemek = new ArrayList<>();
            for (int i = 0; i < nodeLista.getLength(); i++) {
                elemek.add((Element) nodeLista.item(i));
            }
            logger.info("Ki lett olvasva egy elem a listából");
            return elemek;

        } catch (SAXException | IOException ex) {
            logger.error("SAXEception or IOException");

        }
        return null;
    }

    @Override
    public List<Element> sortPlayersByScore(List<Element> list) {
        logger.info("Sorba lett rendezve a lista");
        return list.stream().sorted((t1, t2) -> Integer.parseInt(t2.getElementsByTagName("points").item(0).getTextContent()) - Integer.parseInt(t1.getElementsByTagName("points").item(0).getTextContent())).collect(Collectors.toList());
    }

    @Override
    public void addNewPlayer(Path path, Player gamer) {
        try {
            Document doc;
            Element gyoker;

            File file = path.toFile();

            doc = builder.parse(file);
            gyoker = doc.getDocumentElement();

            Element player = doc.createElement("player");
            Element point = doc.createElement("points");
            point.appendChild(doc.createTextNode(Integer.toString(gamer.getPoints())));
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(gamer.getName()));
            Element date = doc.createElement("date");
            date.appendChild(doc.createTextNode(gamer.getLocalDate().toString()));

            player.appendChild(name);
            player.appendChild(point);
            player.appendChild(date);
            gyoker.appendChild(player);

            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();
            DOMSource domForras = new DOMSource(doc);
            FileOutputStream asd = new FileOutputStream(path.toFile());
            StreamResult ujFajl = new StreamResult(asd);
            trans.transform(domForras, ujFajl);
            logger.info("Egy új player lett hozzáadva az Players.xml fájlhoz.");

        } catch (SAXException | IOException | TransformerException ex) {
            logger.error("SAXEception or IOException or TransfromerException");

        }
    }

}
