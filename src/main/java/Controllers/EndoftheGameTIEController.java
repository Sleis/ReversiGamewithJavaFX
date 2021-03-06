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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class
 *
 * @author Iványi Dániel
 */
public class EndoftheGameTIEController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label labelPoints;

    @FXML
    private Button buttonMenu;
    private static Logger logger = LoggerFactory.getLogger(EndoftheGameTIEController.class);

    @FXML
    private void handleMenu(ActionEvent event) throws IOException {
        logger.info("Rákatintottál a Menu gombra.");

        Stage stage;
        Parent root;
        stage = (Stage) buttonMenu.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeScene.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings("javadocmethod")
    public void initPoints(int points) {
        logger.debug("Inicializálodott a pontszám");
        labelPoints.setText(Integer.toString(points));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
