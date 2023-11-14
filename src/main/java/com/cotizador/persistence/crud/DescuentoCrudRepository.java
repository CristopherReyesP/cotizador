package com.cotizador.persistence.crud;

import com.cotizador.persistence.entity.Descuento;
import org.springframework.data.repository.CrudRepository;

public interface DescuentoCrudRepository extends CrudRepository<Descuento, Integer> {
    Descuento findByCliente_TipoClienteID(Integer TipoClienteID);
}
