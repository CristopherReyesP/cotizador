package com.cotizador.persistence.crud;

import com.cotizador.persistence.entity.Descuento;
import com.cotizador.persistence.entity.Tarifa;
import org.springframework.data.repository.CrudRepository;

public interface TarifaCrudRepository extends CrudRepository<Tarifa, Integer> {
    Tarifa findByRegion_RegionID(Integer RegionID);

}
