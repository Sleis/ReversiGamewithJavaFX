package Controllers;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.XMLManagerDao;
import Model.XMLManagerDaoImp;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.w3c.dom.Element;

/**
 * FXML Controller class
 *
 * @author Iványi Dániel
 */
public class HighScoreController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button ButtonBack;

    @FXML
    private GridPane gridPane;

    private final XMLManagerDao manager = new XMLManagerDaoImp();

    @FXML
    private void handleBack(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) ButtonBack.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeScene.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Path p = Paths.get(System.getProperty("user.home"), "Documents", "Reversi", "players.xml");
        if (!p.toFile().isFile()) {
            Path dir = Paths.get(System.getProperty("user.home"), "Documents", "Reversi");
            dir.toFile().mkdirs();
            manager.createPlayers(p);
        }
        List<Element> playerlist = manager.readPlayers(p);
        playerlist = manager.sortPlayersByScore(playerlist);
        Label tmp;
        int howMany = 0;
        if (playerlist.size() < 8) {
            howMany = playerlist.size();
        } else {
            howMany = 8;
        }
        for (int i = 1; i <= howMany; i++) {
            tmp = new Label(playerlist.get(i - 1).getElementsByTagName("name").item(0).getTextContent());
            tmp.setTextFill(Paint.valueOf("WHITE"));
            tmp.setPrefSize(164.0, 21.0);
            tmp.setAlignment(Pos.CENTER);
            gridPane.add(tmp, 1, i);
            tmp = new Label(playerlist.get(i - 1).getElementsByTagName("points").item(0).getTextContent());
            tmp.setTextFill(Paint.valueOf("WHITE"));
            tmp.setPrefSize(164.0, 21.0);
            tmp.setAlignment(Pos.CENTER);
            gridPane.add(tmp, 2, i);
            tmp = new Label(playerlist.get(i - 1).getElementsByTagName("date").item(0).getTextContent());
            tmp.setTextFill(Paint.valueOf("WHITE"));
            tmp.setPrefSize(164.0, 21.0);
            tmp.setAlignment(Pos.CENTER);
            gridPane.add(tmp, 3, i);
        }
    }

}
