package com.cotizador.persistence;

import com.cotizador.persistence.crud.PaisCrudRepository;
import com.cotizador.persistence.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PaisRepository {
    @Autowired
    private PaisCrudRepository paisCrudRepository;
    public List<Pais> getAll(){
        return  (List<Pais>) paisCrudRepository.findAll();
    }
}
