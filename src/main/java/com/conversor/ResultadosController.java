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
    private Label tipoDeConversionLbl, resultado;

    @FXML
    public void getResultado(double valor, double resultado, String tipoDeConversion) {
        this.tipoDeConversionLbl.setText("el resultado de " + valor + " " + tipoDeConversion +  ", es: ");
        this.resultado.setText(String.format("%.2f", resultado));
    }

    @FXML
    private void cerrarPanel() {
        Stage stage = (Stage) resultado.getScene().getWindow();
        Conversor.cerrarVentana(stage);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        resultadosController = this;
    }
}
