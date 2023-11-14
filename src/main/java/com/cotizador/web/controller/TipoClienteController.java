package com.cotizador.web.controller;

import com.cotizador.persistence.TipoClienteRepository;
import com.cotizador.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class TipoClienteController {
    private TipoClienteRepository tipoClienteRepository;

    @Autowired
    public TipoClienteController(TipoClienteRepository tipoClienteRepository) {
        this.tipoClienteRepository = tipoClienteRepository;
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<Cliente> > getAll(){
        return new ResponseEntity<>(tipoClienteRepository.getAll(), HttpStatus.OK);
    }

}
