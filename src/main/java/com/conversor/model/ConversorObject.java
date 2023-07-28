package com.conversor.model;

public abstract class ConversorObject {
    private Integer valueA;
    private Integer valueB;

    ConversorObject(Integer valueA, Integer valueB) {
        
    }

    public abstract double getResultado(Integer valueA, Integer valueB);

    public Integer getValueA() {
        return valueA;
    }

    public void setValueA(Integer valueA) {
        this.valueA = valueA;
    }

    public Integer getValueB() {
        return valueB;
    }

    public void setValueB(Integer valueB) {
        this.valueB = valueB;
    }

}
