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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Iványi Dániel
 */
public class HomeSceneController implements Initializable {

    @FXML
    private Button playGame;

    @FXML
    private Button help;

    @FXML
    private Button highscore;

    @FXML
    private Button quit;

    private static Logger logger = LoggerFactory.getLogger(HomeSceneController.class);

    @FXML
    private void handlePlayGame(ActionEvent event) throws IOException {
        logger.trace("Rákatintottál a Play gombra.");

        Stage stage;
        Parent root;
        stage = (Stage) playGame.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameScene.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleHighscore(ActionEvent event) throws IOException {
        logger.trace("Rákatintottál a HighScore gombra.");

        Stage stage;
        Parent root;
        stage = (Stage) highscore.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HighScore.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleHelp(ActionEvent event) throws IOException {
        logger.trace("Rákatintottál a Help gombra.");

        Stage stage;
        Parent root;
        stage = (Stage) help.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Help.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleQuit(ActionEvent event) {
        logger.trace("Rákatintottál a Quit gombra.");

        Stage stage = (Stage) quit.getScene().getWindow();

        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
