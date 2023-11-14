package com.cotizador.persistence.crud;

import com.cotizador.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface TipoClienteCrudRepository extends CrudRepository<Cliente, Integer> {
}
