package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToBallView() throws IOException {
        App.setRoot("ball");
    }
}