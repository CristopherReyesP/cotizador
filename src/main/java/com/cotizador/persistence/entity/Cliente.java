package com.cotizador.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "TipoCliente")
public class Cliente {
    @Id
    @Column(name = "TipoClienteID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tipoClienteID;
    private String Nombre;
    @OneToOne(mappedBy = "cliente")
    private Descuento descuento;


    public Integer getTipoClienteID() {
        return tipoClienteID;
    }

    public void setTipoClienteID(Integer tipoClienteID) {
        tipoClienteID = tipoClienteID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
