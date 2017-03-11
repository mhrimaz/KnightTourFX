/*
 * The MIT License
 *
 * Copyright 2017 mhrimaz.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package knighttourfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author mhrimaz
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private StackPane boardHolder;

    private SearchAgent agent;
    private Status searchStatus;

    @FXML
    private TextField sizeField;

    @FXML
    private TextField startXField;

    @FXML
    private TextField startYField;

    @FXML
    private Label statusLabel;

    @FXML
    private Label visitedLabel;

    @FXML
    private Label expandedLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private ComboBox<SearchStrategy> algorithmBox;

    /**
     * this method will draw chess board with given queens configuration
     *
     * @param screenSize size of area for drawing chess board
     * @param n board size
     * @param state board state
     * @return group which holds the chess elements
     */
    public static Group constructBoard(int screenSize, int n, ArrayState state) {
        FadeTransition[] list = new FadeTransition[state.getBoardSize() * state.getBoardSize()];
        Group root = new Group();
        boolean color = false;
        double size = (double) (screenSize / n);
        for (int j = 0, xPos = 0, yPos = 0; j < n; j++, xPos += size, yPos = 0) {
            for (int i = 0; i < n; i++, yPos += size, color = !color) {
                Rectangle piece = new Rectangle(size, size);
                Label label = new Label(String.valueOf(state.getPosition(i, j)), piece);
                label.setLayoutX(xPos);
                label.setLayoutY(yPos);
                label.setContentDisplay(ContentDisplay.CENTER);
                label.setOpacity(0.2);
                if (color == false) {
                    piece.setFill(Color.GOLD);
                } else {
                    piece.setFill(Color.MEDIUMSEAGREEN);
                }
                root.getChildren().add(label);
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(900), label);
                fadeTransition.setFromValue(0.2);
                fadeTransition.setByValue(0.1);
                fadeTransition.setToValue(1.0);
                list[state.getPosition(i, j) - 1] = fadeTransition;
            }
            if (n % 2 == 0) {
                color = !color;
            }
        }
        SequentialTransition transitions = new SequentialTransition();
        transitions.getChildren().addAll(list);
        transitions.play();
        return root;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        boardHolder.getChildren().clear();
        int size = Integer.parseInt(sizeField.getText());
        int i = Integer.parseInt(startXField.getText());
        int j = Integer.parseInt(startYField.getText());
        ArrayState initState = new ArrayState(size, i, j);
        Task<ArrayState> task = new Task<ArrayState>() {
            @Override
            protected ArrayState call() throws Exception {
                return agent.performSearch(initState,
                        algorithmBox.getSelectionModel().getSelectedItem(), searchStatus);
            }

            @Override
            protected void succeeded() {
                Group constructBoard = constructBoard(
                        (int) Math.min(boardHolder.getHeight(), boardHolder.getWidth()),
                        size, getValue());
                boardHolder.getChildren().add(constructBoard);
                setResult();
            }

        };
        new Thread(task).start();
    }

    private void setResult() {
        timeLabel.setText(String.valueOf(searchStatus.getTakenTime()));
        expandedLabel.setText(String.valueOf(searchStatus.getExpandedNode()));
        visitedLabel.setText(String.valueOf(searchStatus.getVisitedNode()));
        timeLabel.setText(searchStatus.getTakenTime() + " ms");
        statusLabel.setText(searchStatus.getStatus());
        searchStatus = new Status();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agent = new SearchAgent();
        searchStatus = new Status();
        algorithmBox.getItems().addAll(SearchStrategy.BFS, SearchStrategy.DFS,
                SearchStrategy.A_STAR, SearchStrategy.GREEDY,
                SearchStrategy.UCS, SearchStrategy.RBFS);
    }

}
