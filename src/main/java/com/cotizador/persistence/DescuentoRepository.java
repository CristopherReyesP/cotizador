package com.cotizador.persistence;

import com.cotizador.persistence.crud.DescuentoCrudRepository;
import com.cotizador.persistence.entity.Descuento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DescuentoRepository {
    @Autowired
    private DescuentoCrudRepository descuentoCrudRepository;
    public List<Descuento> getAll(){
        return (List<Descuento>) descuentoCrudRepository.findAll();
    }

    public Descuento getByTipoCliente(Integer tipoClienteID){
        return descuentoCrudRepository.findByCliente_TipoClienteID(tipoClienteID);
    }
}
