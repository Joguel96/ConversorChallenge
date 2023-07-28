package com.conversor.servicios;

import java.util.HashMap;
import java.util.Map;

import com.conversor.model.CategoriaConversion;
import com.conversor.model.OpcionesEnum;

public class ConversionService {

    private Map<CategoriaConversion, Map<OpcionesEnum, Double>> conversionesMap;

    public ConversionService() {
        conversionesMap = new HashMap<>();
        inicializarConversiones();
    }

    private void inicializarConversiones() {
        // Para DIVISAS
        Map<OpcionesEnum, Double> divisasMap = new HashMap<>();
        divisasMap.put(OpcionesEnum.PESO_A_DOLAR, 0.059);
        divisasMap.put(OpcionesEnum.PESO_A_EURO, 0.054);
        divisasMap.put(OpcionesEnum.PESO_A_LIBRA_ESTERLINA, 0.046);
        divisasMap.put(OpcionesEnum.PESO_A_YEN, 8.33);
        divisasMap.put(OpcionesEnum.PESO_A_WON, 75.80);
        divisasMap.put(OpcionesEnum.DOLAR_A_PESO, 16.84);
        divisasMap.put(OpcionesEnum.EURO_A_PESO, 18.67);
        divisasMap.put(OpcionesEnum.LIBRA_ESTERLINA_A_PESO, 21.80);
        divisasMap.put(OpcionesEnum.YEN_A_PESO, 0.12);
        divisasMap.put(OpcionesEnum.WON_A_PESO, 0.65);
        conversionesMap.put(CategoriaConversion.DIVISAS, divisasMap);

        // Para LONGITUD
        Map<OpcionesEnum, Double> longitudMap = new HashMap<>();
        longitudMap.put(OpcionesEnum.CENTIMETRO_A_PULGADA, 0.393701);
        longitudMap.put(OpcionesEnum.PULGADA_A_CENTIMETRO, 2.54);
        longitudMap.put(OpcionesEnum.METRO_A_PIES, 3.28084);
        longitudMap.put(OpcionesEnum.PIES_A_METRO, 0.3048);
        longitudMap.put(OpcionesEnum.KILOMETRO_A_MILLA, 0.621371);
        longitudMap.put(OpcionesEnum.MILLA_A_KILOMETRO, 1.60934);
        conversionesMap.put(CategoriaConversion.LONGITUD, longitudMap);

        // Para PESO
        Map<OpcionesEnum, Double> pesoMap = new HashMap<>();
        pesoMap.put(OpcionesEnum.GRAMO_A_ONZA, 0.03527396);
        pesoMap.put(OpcionesEnum.ONZA_A_GRAMO, 28.34952);
        pesoMap.put(OpcionesEnum.KILOGRAMO_A_LIBRA, 2.20462);
        pesoMap.put(OpcionesEnum.LIBRA_A_KILOGRAMO, 0.453592);
        pesoMap.put(OpcionesEnum.TONELADA_A_TONELADA_CORTA, 1.10231);
        pesoMap.put(OpcionesEnum.TONELADA_CORTA_A_TONELADA, 0.907185);
        conversionesMap.put(CategoriaConversion.PESO, pesoMap);

        // Para TEMPERATURA
        Map<OpcionesEnum, Double> temperaturaMap = new HashMap<>();
        temperaturaMap.put(OpcionesEnum.CENTIGRADOS_A_FARENHEIT, 33.8);
        temperaturaMap.put(OpcionesEnum.FARENHEIT_A_CENTIGRADOS, -17.2222);
        conversionesMap.put(CategoriaConversion.TEMPERATURA, temperaturaMap);

        // Para ALMACENAMIENTO DE DATOS
        Map<OpcionesEnum, Double> almacenamientoMap = new HashMap<>();
        almacenamientoMap.put(OpcionesEnum.BIT_A_BYTE, 0.125);
        almacenamientoMap.put(OpcionesEnum.BYTE_A_KILOBYTE, 0.000976563);
        almacenamientoMap.put(OpcionesEnum.KILOBYTE_A_MEGABYTE, 0.000976563);
        almacenamientoMap.put(OpcionesEnum.MEGABYTE_A_GIGABYTE, 0.000976563);
        almacenamientoMap.put(OpcionesEnum.GIGABYTE_A_TERABYTE, 0.000976563);
        almacenamientoMap.put(OpcionesEnum.BYTE_A_BIT, 8.0);
        almacenamientoMap.put(OpcionesEnum.KILOBYTE_A_BYTE, 1024.0);
        almacenamientoMap.put(OpcionesEnum.MEGABYTE_A_KILOBYTE, 1024.0);
        almacenamientoMap.put(OpcionesEnum.GIGABYTE_A_MEGABYTE, 1024.0);
        almacenamientoMap.put(OpcionesEnum.TERABYTE_A_GIGABYTE, 1024.0);
        conversionesMap.put(CategoriaConversion.ALMACENAMIENTO, almacenamientoMap);

        // Agregar más categorías y tipos de cambio si es necesario
    }

    public double getResultado(CategoriaConversion categoria, OpcionesEnum tipo, double valor) {
        switch (categoria) {
            case TEMPERATURA:
                if (tipo == OpcionesEnum.CENTIGRADOS_A_FARENHEIT) {
                    // Conversión específica de Celsius a Fahrenheit
                    return (valor * 9 / 5) + 32;
                } else if (tipo == OpcionesEnum.FARENHEIT_A_CENTIGRADOS) {
                    // Conversión específica de Fahrenheit a Celsius
                    return (valor - 32) * 5 / 9;
                }
                break;
            case ALMACENAMIENTO:
                if (tipo == OpcionesEnum.BIT_A_BYTE) {
                    return valor / 8;
                } else if (tipo == OpcionesEnum.BYTE_A_KILOBYTE) {
                    return valor / 1024;
                } else if (tipo == OpcionesEnum.KILOBYTE_A_MEGABYTE) {
                    return valor / 1024;
                } else if (tipo == OpcionesEnum.MEGABYTE_A_GIGABYTE) {
                    return valor / 1024;
                } else if (tipo == OpcionesEnum.GIGABYTE_A_TERABYTE) {
                    return valor / 1024;
                }
                break;
            default:
                Map<OpcionesEnum, Double> tipoDeCambioMap = conversionesMap.get(categoria);
                if (tipoDeCambioMap != null) {
                    Double factorConversion = tipoDeCambioMap.get(tipo);
                    if (factorConversion != null) {
                        return valor * factorConversion;
                    }
                }
                break;
        }
        return 0;
    } 
}
