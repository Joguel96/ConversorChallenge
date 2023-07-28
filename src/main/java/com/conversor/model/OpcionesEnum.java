package com.conversor.model;

public enum OpcionesEnum {
    // DIVISAS
    PESO_A_DOLAR("Peso (MXN)", "Dolar Americano (DLLS)"),
    PESO_A_EURO("Peso (MXN)", "Euro (EUR)"),
    PESO_A_LIBRA_ESTERLINA("Peso (MXN)", "Libra Esterlina (GBP)"),
    PESO_A_YEN("Peso (MXN)", "Yen Japones (JPY)"),
    PESO_A_WON("Peso (MXN)", "Won Sur-coreano (KRW)"),
    DOLAR_A_PESO("Dolar Americano (DLLS)", "Peso (MXN)"),
    EURO_A_PESO("Euro (EUR)", "Peso (MXN)"),
    LIBRA_ESTERLINA_A_PESO("Libra Esterlina (GBP)", "Peso (MXN)"),
    YEN_A_PESO("Yen Japones (JPY)", "Peso (MXN)"),
    WON_A_PESO("Won Sur-coreano (KRW)", "Peso (MXN)"),

    // LONGITUD
    CENTIMETRO_A_PULGADA("Centímetros", "Pulgadas"),
    PULGADA_A_CENTIMETRO("Pulgadas", "Centímetros"),
    METRO_A_PIES("Metros", "Pies"),
    PIES_A_METRO("Pies", "Metros"),
    KILOMETRO_A_MILLA("Kilometros", "Millas"),
    MILLA_A_KILOMETRO("Millsa", "Kilómetros"),

    // PESO
    GRAMO_A_ONZA("Gramos", "Onzas"),
    ONZA_A_GRAMO("Onzas", "Gramos"),
    KILOGRAMO_A_LIBRA("Kilogramos", "Libras"),
    LIBRA_A_KILOGRAMO("Libras", "Kilogramos"),
    TONELADA_A_TONELADA_CORTA("Toneladas", "Toneladas Cortas"),
    TONELADA_CORTA_A_TONELADA("Toneladas Cortas", "Toneladas"),

    // TEMPERATURA
    CENTIGRADOS_A_FARENHEIT("Centígrados", "Fahrenheit"),
    FARENHEIT_A_CENTIGRADOS("Fahrenheit", "Centígrados"),

    // ALMACENAMIENTO DE DATOS
    BIT_A_BYTE("Bit", "Byte"),
    BYTE_A_KILOBYTE("Byte", "Kilobyte"),
    KILOBYTE_A_MEGABYTE("Kilobyte", "Megabyte"),
    MEGABYTE_A_GIGABYTE("Megabyte", "Gigabyte"),
    GIGABYTE_A_TERABYTE("Gigabyte", "Terabyte"),
    BYTE_A_BIT("Byte", "Bit"),
    KILOBYTE_A_BYTE("Kilobyte", "Byte"),
    MEGABYTE_A_KILOBYTE("Megabyte", "Kilobyte"),
    GIGABYTE_A_MEGABYTE("Gigabyte", "Megabyte"),
    TERABYTE_A_GIGABYTE("Terabyte", "Gigabyte");

    private final String valor1;
    private final String valor2;

    // Constructor del enum
    OpcionesEnum(String valor1, String valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public String getValor1() {
        return valor1;
    }

    public String getValor2() {
        return valor2;
    }
}
