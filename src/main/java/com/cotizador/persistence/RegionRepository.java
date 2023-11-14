package com.cotizador.persistence;

import com.cotizador.persistence.crud.RegionCrudRepository;
import com.cotizador.persistence.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RegionRepository {
    @Autowired
    private RegionCrudRepository regionCrudRepository;

    public List<Region> getAll(){
        return (List<Region>) regionCrudRepository.findAll();
    }
}
