package com.cotizador.persistence.entity;

import jakarta.persistence.*;

@Entity
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer TarifaID;
    private double Precio;
    @OneToOne
    @JoinColumn(name = "RegionID")
    private Region region;

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    public Integer getTarifaID() {
        return TarifaID;
    }

    public void setTarifaID(Integer tarifaID) {
        TarifaID = tarifaID;
    }



}
