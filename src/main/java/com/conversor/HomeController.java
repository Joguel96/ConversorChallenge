package com.conversor;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ValorInvalidoException;

public class HomeController implements Initializable {

    HomeController homeController;

    @FXML
    private TextField
            barraDeEstado,
            input1,
            input2;

    @FXML
    private Label
            in1Label,
            in2Label;

    private SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");

    @FXML
    private void conversion() throws IOException, ValorInvalidoException {
        String valor1 = input1.getText();
        String valor2 = input2.getText();

        if (validaCampos(valor1, valor2)) {
            Main.mostrarAlerta("Error", "Ambos campos deben tener valores numéricos.", Alert.AlertType.ERROR);
            return;
        }

        try {
            double resultado = Double.parseDouble(valor1) + Double.parseDouble(valor2);
            showResultados(resultado);
        } catch (NumberFormatException | ValorInvalidoException e) {
            throw new ValorInvalidoException("Ambos campos deben tener valores numéricos válidos.");
        }

        Alert alert = Main.mostrarAlerta("Confirmación", "¿Desea continuar con el servicio de conversion?",
                Alert.AlertType.CONFIRMATION);
        if (alert.getResult() == ButtonType.CANCEL) {
            cerrarAplicacion();
            return;
        }

    }

    private void showResultados(double resultado) throws IOException, ValorInvalidoException {
        Stage resultadosStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        VBox root = (VBox) loader.load(getClass().getResource("resultados.fxml").openStream());

        ResultadosController resultadosController = (ResultadosController) loader.getController();

        resultadosController.getResultado(resultado);

        Scene scene = new Scene(root);
        resultadosStage.setTitle("Resultado Conversion");
        resultadosStage.alwaysOnTopProperty();
        resultadosStage.setResizable(false);
        resultadosStage.setMaximized(false);
        resultadosStage.setFullScreen(false);
        resultadosStage.setScene(scene);
        resultadosStage.initModality(Modality.APPLICATION_MODAL);
        resultadosStage.showAndWait();

    }

    private boolean validaCampos(String input1, String input2) {
        return input1.isEmpty() || input2.isEmpty();
    }

    @FXML
    private void cerrarAplicacion() {
        Main.mostrarAlerta("Aviso", "Programa finalizado", Alert.AlertType.INFORMATION);
        Platform.exit();
    }

    @FXML
    private void showReadme() {
        System.out.println("readme");
    }

    @FXML
    private void showAbout() {
        System.out.println("Acerca de");
    }

    @FXML
    private void limpiarValores() {
        input1.setText("");
        input2.setText("");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        homeController = this;

        Date fechaActual = new Date();
        String fechaFormateada = fechaFormato.format(fechaActual);
        barraDeEstado.setText("Fecha actual: " + fechaFormateada);
    }

}
