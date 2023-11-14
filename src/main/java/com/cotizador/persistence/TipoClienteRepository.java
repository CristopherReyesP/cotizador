package com.cotizador.persistence;

import com.cotizador.persistence.crud.TipoClienteCrudRepository;
import com.cotizador.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TipoClienteRepository {
    @Autowired
    private TipoClienteCrudRepository tipoClienteCrudRepository;
    public List<Cliente> getAll(){return (List<Cliente>) tipoClienteCrudRepository.findAll();
    }
}
