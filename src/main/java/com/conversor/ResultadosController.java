package com.conversor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultadosController implements Initializable {

    ResultadosController resultadosController;
    
    @FXML
    private Label
    ValorA,
    ValorB,
    resultado;

    @FXML
    public void getResultado(Number resultado){
        System.out.println("el resultado es: " + resultado);
        this.resultado.setText("el resultado es: " + resultado);
    }

    @FXML
    private void cerrarPanel(){
        Stage stage = (Stage) resultado.getScene().getWindow();
        Main.cerrarVentana(stage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        resultadosController = this;
    }
}
