package com.conversor.model;

import com.conversor.Conversor;

import javafx.scene.control.Alert;

public class ValorInvalidoException extends Exception {
    
    public ValorInvalidoException(String mensaje){
        super(mensaje);
        Conversor.mostrarAlerta("Alerta", mensaje, Alert.AlertType.WARNING);
    }
}
