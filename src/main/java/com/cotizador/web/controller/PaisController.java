package com.cotizador.web.controller;

import com.cotizador.persistence.PaisRepository;
import com.cotizador.persistence.entity.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {
    private final PaisRepository paisRepository;

    @Autowired
    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }
    @GetMapping("/obtener")
    public ResponseEntity<List<Pais>> getAll(){

        return  new ResponseEntity<>( paisRepository.getAll(), HttpStatus.OK);
    }
}
