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
package Controllers;

import Model.Cell;
import Model.Position;
import Model.ReversiEngine;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameController implements Initializable {

    private static Logger logger = LoggerFactory.getLogger(GameController.class);

    @FXML
    private GridPane GridPanel;

    @FXML
    private StackPane stackPane0_0;
    @FXML
    private StackPane stackPane0_1;
    @FXML
    private StackPane stackPane0_2;
    @FXML
    private StackPane stackPane0_3;
    @FXML
    private StackPane stackPane0_4;
    @FXML
    private StackPane stackPane0_5;
    @FXML
    private StackPane stackPane0_6;
    @FXML
    private StackPane stackPane0_7;

    @FXML
    private StackPane stackPane1_0;
    @FXML
    private StackPane stackPane1_1;
    @FXML
    private StackPane stackPane1_2;
    @FXML
    private StackPane stackPane1_3;
    @FXML
    private StackPane stackPane1_4;
    @FXML
    private StackPane stackPane1_5;
    @FXML
    private StackPane stackPane1_6;
    @FXML
    private StackPane stackPane1_7;

    @FXML
    private StackPane stackPane2_0;
    @FXML
    private StackPane stackPane2_1;
    @FXML
    private StackPane stackPane2_2;
    @FXML
    private StackPane stackPane2_3;
    @FXML
    private StackPane stackPane2_4;
    @FXML
    private StackPane stackPane2_5;
    @FXML
    private StackPane stackPane2_6;
    @FXML
    private StackPane stackPane2_7;

    @FXML
    private StackPane stackPane3_0;
    @FXML
    private StackPane stackPane3_1;
    @FXML
    private StackPane stackPane3_2;
    @FXML
    private StackPane stackPane3_3;
    @FXML
    private StackPane stackPane3_4;
    @FXML
    private StackPane stackPane3_5;
    @FXML
    private StackPane stackPane3_6;
    @FXML
    private StackPane stackPane3_7;

    @FXML
    private StackPane stackPane4_0;
    @FXML
    private StackPane stackPane4_1;
    @FXML
    private StackPane stackPane4_2;
    @FXML
    private StackPane stackPane4_3;
    @FXML
    private StackPane stackPane4_4;
    @FXML
    private StackPane stackPane4_5;
    @FXML
    private StackPane stackPane4_6;
    @FXML
    private StackPane stackPane4_7;

    @FXML
    private StackPane stackPane5_0;
    @FXML
    private StackPane stackPane5_1;
    @FXML
    private StackPane stackPane5_2;
    @FXML
    private StackPane stackPane5_3;
    @FXML
    private StackPane stackPane5_4;
    @FXML
    private StackPane stackPane5_5;
    @FXML
    private StackPane stackPane5_6;
    @FXML
    private StackPane stackPane5_7;

    @FXML
    private StackPane stackPane6_0;
    @FXML
    private StackPane stackPane6_1;
    @FXML
    private StackPane stackPane6_2;
    @FXML
    private StackPane stackPane6_3;
    @FXML
    private StackPane stackPane6_4;
    @FXML
    private StackPane stackPane6_5;
    @FXML
    private StackPane stackPane6_6;
    @FXML
    private StackPane stackPane6_7;

    @FXML
    private StackPane stackPane7_0;
    @FXML
    private StackPane stackPane7_1;
    @FXML
    private StackPane stackPane7_2;
    @FXML
    private StackPane stackPane7_3;
    @FXML
    private StackPane stackPane7_4;
    @FXML
    private StackPane stackPane7_5;
    @FXML
    private StackPane stackPane7_6;
    @FXML
    private StackPane stackPane7_7;

    @FXML
    private Label whosNext;
    @FXML
    private Label blackNumber;
    @FXML
    private Label whiteNumber;
    @FXML
    private Label error;

    @FXML
    private Button buttonMenuGame;

    private StackPane[][] feltolt() {
        StackPane temp[][] = new StackPane[8][8];

        temp[0][0] = stackPane0_0;
        temp[0][1] = stackPane0_1;
        temp[0][2] = stackPane0_2;
        temp[0][3] = stackPane0_3;
        temp[0][4] = stackPane0_4;
        temp[0][5] = stackPane0_5;
        temp[0][6] = stackPane0_6;
        temp[0][7] = stackPane0_7;

        temp[1][0] = stackPane1_0;
        temp[1][1] = stackPane1_1;
        temp[1][2] = stackPane1_2;
        temp[1][3] = stackPane1_3;
        temp[1][4] = stackPane1_4;
        temp[1][5] = stackPane1_5;
        temp[1][6] = stackPane1_6;
        temp[1][7] = stackPane1_7;

        temp[2][0] = stackPane2_0;
        temp[2][1] = stackPane2_1;
        temp[2][2] = stackPane2_2;
        temp[2][3] = stackPane2_3;
        temp[2][4] = stackPane2_4;
        temp[2][5] = stackPane2_5;
        temp[2][6] = stackPane2_6;
        temp[2][7] = stackPane2_7;

        temp[3][0] = stackPane3_0;
        temp[3][1] = stackPane3_1;
        temp[3][2] = stackPane3_2;
        temp[3][3] = stackPane3_3;
        temp[3][4] = stackPane3_4;
        temp[3][5] = stackPane3_5;
        temp[3][6] = stackPane3_6;
        temp[3][7] = stackPane3_7;

        temp[4][0] = stackPane4_0;
        temp[4][1] = stackPane4_1;
        temp[4][2] = stackPane4_2;
        temp[4][3] = stackPane4_3;
        temp[4][4] = stackPane4_4;
        temp[4][5] = stackPane4_5;
        temp[4][6] = stackPane4_6;
        temp[4][7] = stackPane4_7;

        temp[5][0] = stackPane5_0;
        temp[5][1] = stackPane5_1;
        temp[5][2] = stackPane5_2;
        temp[5][3] = stackPane5_3;
        temp[5][4] = stackPane5_4;
        temp[5][5] = stackPane5_5;
        temp[5][6] = stackPane5_6;
        temp[5][7] = stackPane5_7;

        temp[6][0] = stackPane6_0;
        temp[6][1] = stackPane6_1;
        temp[6][2] = stackPane6_2;
        temp[6][3] = stackPane6_3;
        temp[6][4] = stackPane6_4;
        temp[6][5] = stackPane6_5;
        temp[6][6] = stackPane6_6;
        temp[6][7] = stackPane6_7;

        temp[7][0] = stackPane7_0;
        temp[7][1] = stackPane7_1;
        temp[7][2] = stackPane7_2;
        temp[7][3] = stackPane7_3;
        temp[7][4] = stackPane7_4;
        temp[7][5] = stackPane7_5;
        temp[7][6] = stackPane7_6;
        temp[7][7] = stackPane7_7;

        return temp;
    }

    private Cell[][] uploadCell(StackPane[][] allStackPane) {
        Cell[][] tmp = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (allStackPane[i][j].getChildren().isEmpty()) {
                    tmp[i][j] = new Cell("");
                } else if (allStackPane[i][j].getChildren().get(0).getStyle().equals("-fx-fill: white;")) {
                    tmp[i][j] = new Cell("white");
                } else {
                    tmp[i][j] = new Cell("black");
                }
            }
        }
        return tmp;
    }

    private Circle newcircle() {
        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setStroke(Color.BLACK);
        return circle;
    }

    private Position whichposition(MouseEvent event, StackPane[][] osszes) {
        Position tmp = new Position();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (event.getTarget().equals(osszes[i][j])) {
                    tmp.setSor(i);
                    tmp.setOszlop(j);
                }
                if (event.getTarget().getClass().equals(Circle.class)) {
                    Circle circle = (Circle) event.getTarget();
                    if (circle.getParent().equals(osszes[i][j])) {
                        tmp.setSor(i);
                        tmp.setOszlop(j);
                    }
                }
            }
        }
        return tmp;
    }

    private void settings(Cell[][] allCell, StackPane[][] allStackPane) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (allCell[i][j].getColor().equals("white")) {
                    logger.debug("Fehér kört raktunk az adott cellába.");
                    if (allStackPane[i][j].getChildren().isEmpty()) {
                        Circle circle = newcircle();
                        circle.setStyle("-fx-fill: white;");
                        allStackPane[i][j].getChildren().add(circle);
                    } else {
                        allStackPane[i][j].getChildren().get(0).setStyle("-fx-fill: white;");
                    }
                } else if (allCell[i][j].getColor().equals("black")) {
                    logger.debug("Fekete kört raktunk az adott cellába.");
                    if (allStackPane[i][j].getChildren().isEmpty()) {
                        Circle circle = newcircle();
                        circle.setStyle("-fx-fill: black;");
                        allStackPane[i][j].getChildren().add(circle);
                    } else {
                        allStackPane[i][j].getChildren().get(0).setStyle("-fx-fill: black;");
                    }
                }
            }
        }
    }

    @FXML
    private void handleClickAction(MouseEvent event) throws IOException {
        logger.info("A GameController osztály handleClickAction metódusa meghívódott.");

        StackPane osszes[][];
        Cell[][] all;
        Position index;

        osszes = feltolt();
        all = uploadCell(osszes);

        error.setText("");

        ReversiEngine reversiEngine = new ReversiEngine();
        index = whichposition(event, osszes);
        reversiEngine.run(all, index);
        settings(all, osszes);
        error.setText(reversiEngine.getMessage());
        if (reversiEngine.isIsEnd()) {
            if (reversiEngine.whosWinner(all).equals("Tie")) {
                logger.debug("A meccs döntetlen.");
                Stage stage;
                Parent root;
                stage = (Stage) buttonMenuGame.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EndoftheGameTIE.fxml"));
                root = loader.load();
                loader.<EndoftheGameTIEController>getController().initPoints(reversiEngine.winnersPoints(all));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                logger.debug("A meccset valaki megnyerte.");
                Stage stage;
                Parent root;
                stage = (Stage) buttonMenuGame.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EndoftheGame.fxml"));
                root = loader.load();
                loader.<EndoftheGameController>getController().initWinner(reversiEngine.whosWinner(all));
                loader.<EndoftheGameController>getController().initPoints(reversiEngine.winnersPoints(all));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        blackNumber.setText(Integer.toString(reversiEngine.getBlackAndWhite()[1]));
        whiteNumber.setText(Integer.toString(reversiEngine.getBlackAndWhite()[0]));
        if (reversiEngine.getNextPlayer() % 2 == 0) {
            whosNext.setText("White");
        } else {
            whosNext.setText("Black");
        }

    }

    @FXML
    private void handleMenuGame(ActionEvent event) throws IOException {
        logger.info("A GameController osztály handleMenuGame metódusa meghívódott.");
        Stage stage;
        Parent root;
        stage = (Stage) buttonMenuGame.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/HomeScene.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
