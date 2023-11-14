package com.cotizador.persistence;

import com.cotizador.persistence.crud.TarifaCrudRepository;
import com.cotizador.persistence.entity.Descuento;
import com.cotizador.persistence.entity.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TarifaRepository {
    @Autowired
    private TarifaCrudRepository tarifaCrudRepository;
    public List<Tarifa> getAll(){
        return (List<Tarifa>) tarifaCrudRepository.findAll();
    }

    public Tarifa getByRegion(Integer regionID){
        return tarifaCrudRepository.findByRegion_RegionID(regionID);
    }
}
