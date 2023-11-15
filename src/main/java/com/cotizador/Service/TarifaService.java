package com.cotizador.Service;

import com.cotizador.persistence.DescuentoRepository;
import com.cotizador.persistence.TarifaRepository;
import com.cotizador.persistence.entity.Descuento;
import com.cotizador.persistence.entity.Paquete;

import com.cotizador.persistence.entity.Tarifa;
import com.cotizador.persistence.entity.TarifaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    private final TarifaRepository tarifaRepository;
    private final DescuentoRepository descuentoRepository;

    @Autowired
    public TarifaService(TarifaRepository tarifaRepository, DescuentoRepository descuentoRepository) {
        this.tarifaRepository = tarifaRepository;
        this.descuentoRepository = descuentoRepository;
    }
    public TarifaResponse calcularTarifa(Paquete paquete) {

        TarifaResponse tarifaResponse = new TarifaResponse();

        Tarifa tarifa = tarifaRepository.getByRegion(paquete.getRegion());
        Descuento descuentoCliente = descuentoRepository.getByTipoCliente(paquete.getTipocliente());

        double monto = paquete.getPeso() * tarifa.getPrecio();
        double adicionales = 1.66 * paquete.getAlto() * paquete.getLargo() * paquete.getAncho();
        double descuento = descuentoCliente.getPorcentaje() * 0.5 * paquete.getPeso();

       tarifaResponse.setMonto(monto);
       tarifaResponse.setAdicionales(adicionales);
       tarifaResponse.setDescuento(descuento);

        return tarifaResponse;
    }

}
