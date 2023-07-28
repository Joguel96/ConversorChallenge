package com.conversor.model;

import com.conversor.Main;

import javafx.scene.control.Alert;

public class ValorInvalidoException extends Exception {
    
    public ValorInvalidoException(String mensaje){
        super(mensaje);
        Main.mostrarAlerta("Alerta", mensaje, Alert.AlertType.WARNING);
    }
}
