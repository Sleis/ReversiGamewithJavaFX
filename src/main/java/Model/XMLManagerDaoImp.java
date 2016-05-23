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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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
 * Implementálja az XMLManagerDAO interfészt.
 *
 * @author Iványi Dániel
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Path path) {
        try {
            Document doc = builder.newDocument();
            Element root = doc.createElement("players");
            doc.appendChild(root);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer trans = tFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult newFile = new StreamResult(path.toFile());
            trans.transform(domSource, newFile);

        } catch (TransformerException ex) {
            logger.error("TransformerException");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Element> read(Path path) {
        try {
            File file = path.toFile();
            Document doc = builder.parse(file);
            NodeList nodeLista = doc.getElementsByTagName("player");
            List<Element> elements = new ArrayList<>();
            for (int i = 0; i < nodeLista.getLength(); i++) {
                elements.add((Element) nodeLista.item(i));
            }
            logger.debug("Ki lett olvasva az összes elem az XML fájlból");
            return elements;

        } catch (SAXException | IOException ex) {
            logger.error("SAXEception or IOException");

        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Element> sortByScore(List<Element> list) {
        logger.debug("Sorba lett rendezve a lista");
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Element max = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (Integer.parseInt(max.getElementsByTagName("points").item(0).getTextContent()) < Integer.parseInt(list.get(j).getElementsByTagName("points").item(0).getTextContent())) {
                    max = list.get(j);
                    index = j;
                }
            }
            Element seged = list.get(i);
            list.set(i, max);
            list.set(index, seged);
        }
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(Path path, Player gamer) {
        try {
            Document doc;
            Element root;

            File file = path.toFile();

            doc = builder.parse(file);
            root = doc.getDocumentElement();

            Element player = doc.createElement("player");
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(gamer.getName()));
            Element point = doc.createElement("points");
            point.appendChild(doc.createTextNode(Integer.toString(gamer.getPoints())));
            Element date = doc.createElement("date");
            date.appendChild(doc.createTextNode(gamer.getLocalDate().toString()));

            player.appendChild(name);
            player.appendChild(point);
            player.appendChild(date);
            root.appendChild(player);

            TransformerFactory tFact = TransformerFactory.newInstance();
            Transformer trans = tFact.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            FileOutputStream asd = new FileOutputStream(path.toFile());
            StreamResult newFile = new StreamResult(asd);
            trans.transform(domSource, newFile);
            logger.debug("Egy új player lett hozzáadva a players.xml fájlhoz.");

        } catch (SAXException | IOException | TransformerException ex) {
            logger.error("SAXEception or IOException or TransfromerException");

        }
    }

}
