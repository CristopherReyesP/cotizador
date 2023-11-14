package com.cotizador.persistence.entity;

import jakarta.persistence.*;

@Entity
public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DescuentoID;
    private double Porcentaje;
    @OneToOne
    @JoinColumn(name = "TipoClienteID" )
    private Cliente cliente;
    public Integer getDescuentoID() {
        return DescuentoID;
    }

    public void setDescuentoID(Integer descuentoID) {
        DescuentoID = descuentoID;
    }

    public double getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        Porcentaje = porcentaje;
    }


}
