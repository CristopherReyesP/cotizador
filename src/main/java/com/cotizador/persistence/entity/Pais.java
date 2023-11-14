package com.cotizador.persistence.entity;

import jakarta.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PaisID;
    private String Nombre;
    @ManyToOne
    @JoinColumn(name = "RegionID" ) //,insertable=false, updatable=false
    private Region region;

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getPaisID() {
        return PaisID;
    }

    public void setPaisID(Integer paisID) {
        PaisID = paisID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


}
