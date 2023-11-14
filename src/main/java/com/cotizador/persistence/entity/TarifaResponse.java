package com.cotizador.persistence.entity;

public class TarifaResponse {
    private double monto;
    private double adicionales;
    private double descuento;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(double adicionales) {
        this.adicionales = adicionales;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
