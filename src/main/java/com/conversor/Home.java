package com.conversor;

import java.io.IOException;
import javafx.fxml.FXML;

public class Home {

    @FXML
    private void switchToSecondary() throws IOException {
        Main.setRoot("secondary");
    }
}
