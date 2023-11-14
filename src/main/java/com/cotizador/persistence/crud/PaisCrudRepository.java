package com.cotizador.persistence.crud;

import com.cotizador.persistence.entity.Pais;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaisCrudRepository extends CrudRepository<Pais, Integer> {
}
