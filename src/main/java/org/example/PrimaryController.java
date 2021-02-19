package org.example;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class PrimaryController {

    @FXML
    private RadioButton randomColor;

    @FXML
    private RadioButton selectColor;

    @FXML
    private ComboBox<Integer> numBalls;

    @FXML
    private ColorPicker ballColor;


    @FXML
    private void startButtonHandler() throws IOException {
        App.setRoot(numBalls.getValue(), selectColor.isSelected() ? ballColor.getValue() : null);
    }

    public void initialize(){
        numBalls.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        numBalls.setValue(1);
        ballColor.setDisable(true);
        randomColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ballColor.setDisable(true);
            }
        });
        selectColor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ballColor.setDisable(false);
            }
        });
    }
}
