package com.conversor;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.conversor.model.CategoriaConversion;
import com.conversor.model.OpcionesEnum;
import com.conversor.model.ValorInvalidoException;
import com.conversor.servicios.ConversionService;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    HomeController homeController;

    @FXML
    private TextField barraDeEstado, inputNum;

    @FXML
    private Label categoriaLabel, inputLabel;

    private SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/MM/yyyy");
    private Map<String, OpcionesEnum> conversionesMap = new HashMap<>();
    private MenuItem menuItem;
    private ConversionService conversionService;
    private String tipoDeConversion;

    @FXML
    private void getTipoConversion(ActionEvent event) {
        menuItem = (MenuItem) event.getSource();
        Menu parentMenu = menuItem.getParentMenu();
        tipoDeConversion = menuItem.getText();
        categoriaLabel.setText(parentMenu.getText());

        OpcionesEnum conversion = conversionesMap.get(tipoDeConversion);
        if (conversion != null) {
            inputLabel.setText(tipoDeConversion);
        } else {
            System.out.println("No se encontró la conversión para: " + tipoDeConversion);
        }
    }

    @FXML
    private void conversion() throws IOException, ValorInvalidoException {
        String valorString = inputNum.getText();

        if (validaServicio(menuItem)) {
            Main.mostrarAlerta("Alerta", "Debes seleccionar un servicio de conversion primero",
                    AlertType.WARNING);
            return;
        }

        if (validaCampos(valorString)) {
            Main.mostrarAlerta("Error", "El campo no puede ir vacio.",
                    AlertType.WARNING);
            return;
        }

        double valorNum;
        try {
            valorNum = Double.parseDouble(valorString);
        } catch (NumberFormatException e) {
            Main.mostrarAlerta("Error", "El campo debe tener un valor numérico.", AlertType.WARNING);
            return;
        }

        try {
            CategoriaConversion categoria = obtenerCategoria();
            OpcionesEnum tipo = conversionesMap.get(menuItem.getText());
            double resultado = conversionService.getResultado(categoria, tipo, valorNum);
            showResultados(valorNum, resultado, tipoDeConversion);
        } catch (ValorInvalidoException e) {
            Main.mostrarAlerta("Error", e.getMessage(), AlertType.ERROR);
        }

        Alert alert = Main.mostrarAlerta("Confirmación", "¿Desea continuar con el servicio de conversion?",
                AlertType.CONFIRMATION);
        if (alert.getResult() == ButtonType.CANCEL) {
            cerrarAplicacion();

            return;
        }

    }

    private CategoriaConversion obtenerCategoria() {
        String categoriaTexto = categoriaLabel.getText();
        return CategoriaConversion.valueOf(categoriaTexto.toUpperCase());
    }

    private void showResultados(double valorNum, double resultado, String valor) throws IOException, ValorInvalidoException {
        Stage resultadosStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        VBox root = (VBox) loader.load(getClass().getResource("resultados.fxml").openStream());

        ResultadosController resultadosController = (ResultadosController) loader.getController();

        resultadosController.getResultado(valorNum, resultado, valor);

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

    private boolean validaCampos(String input1) {
        return input1.isEmpty() || input1.trim().isEmpty();
    }

    private boolean validaServicio(MenuItem menuItem) {
        return menuItem == null;
    }

    @FXML
    private void cerrarAplicacion() {
        Main.mostrarAlerta("Aviso", "Programa finalizado", AlertType.INFORMATION);
        Platform.exit();
    }

    
    @FXML
    private void limpiarValores() {
        inputNum.setText("");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        homeController = this;
        
        Date fechaActual = new Date();
        String fechaFormateada = fechaFormato.format(fechaActual);
        barraDeEstado.setText("Fecha actual: " + fechaFormateada);
        conversionService = new ConversionService();
        
        for (OpcionesEnum conversion : OpcionesEnum.values()) {
            String textoConversion = conversion.getValor1() + " a " + conversion.getValor2();
            conversionesMap.put(textoConversion, conversion);
        }
    }
    
    @FXML
    private void showAbout() {
        String acercaDeMensaje = "Bienvenido a Conversor Challenge G5!\n\n"
                + "Autor: José Miguel Silva Castro\n"
                + "Alias de GitHub: joguel\n"
                + "Versión: 1.0\n\n"
                + "Descripción:\n"
                + "Conversor Challenge G5 es una aplicación de conversión versátil y fácil de usar, "
                + "desarrollada como parte del desafío para la clase de Alura Latam. "
                + "Esta aplicación te permite convertir diferentes unidades y datos en diversas categorías, "
                + "incluyendo divisas, longitudes, peso, temperatura y almacenamiento.\n\n"
                + "Características principales:\n"
                + "- Conversión rápida y precisa entre diferentes unidades.\n"
                + "- Soporte para divisas, longitudes, peso, temperatura y almacenamiento.\n"
                + "- Interfaz gráfica amigable e intuitiva para una experiencia de usuario fluida.\n"
                + "- Muestra el resultado de las conversiones con hasta dos decimales para mayor precisión.\n\n"
                + "¡Esperamos que disfrutes usando Conversor Challenge G5 para tus necesidades de conversión diarias!\n\n"
                + "¡Gracias por usar nuestra aplicación!";

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Acerca de Conversor Challenge G5");
        alerta.setHeaderText(null);
        alerta.setContentText(acercaDeMensaje);
        
        alerta.showAndWait();
    }

}
