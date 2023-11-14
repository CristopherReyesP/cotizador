package com.cotizador.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Region {
    @Id
    @Column(name = "RegionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionID;
    @Column(name = "Nombre")

    private String nombre;
    @OneToMany(mappedBy = "region")
    private List<Pais> pais;

    @OneToOne(mappedBy = "region")
    private Tarifa tarifa;
    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        regionID = regionID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }
}
