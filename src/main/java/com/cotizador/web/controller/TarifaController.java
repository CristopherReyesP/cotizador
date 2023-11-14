package com.cotizador.web.controller;

import com.cotizador.Service.TarifaService;
import com.cotizador.persistence.entity.Paquete;
import com.cotizador.persistence.entity.Tarifa;
import com.cotizador.persistence.entity.TarifaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
    @Autowired
    private TarifaService tarifaService;
    private TarifaResponse tarifaResponse;
    @PostMapping("/calcularTarifa")
    public TarifaResponse calcularTarifa(@RequestBody Paquete paquete) {
        TarifaResponse tarifaResponse= tarifaService.calcularTarifa(paquete);
        return tarifaResponse;
    }

    @GetMapping("/paquete")
    public ResponseEntity<Paquete> enviar(){
        Paquete paquete = new Paquete();
        paquete.setAlto(2.5);
        paquete.setAncho(3);
        paquete.setLargo(2);
        paquete.setPeso(10);
        paquete.setRegion(1);
        paquete.setTipocliente(2);
        return  ResponseEntity.ok(paquete);
    }


}
