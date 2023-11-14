package com.cotizador.persistence.crud;

import com.cotizador.persistence.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionCrudRepository extends CrudRepository<Region, Integer> {
}
