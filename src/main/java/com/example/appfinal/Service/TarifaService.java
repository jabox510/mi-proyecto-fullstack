package com.example.appfinal.Service;


import com.example.appfinal.Model.Tarifa;
import com.example.appfinal.Model.TipoVehiculo;
import com.example.appfinal.Repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    public Tarifa cambiarTarifa(TipoVehiculo tipoVehiculo, Double nuevoValor) {
        Tarifa tarifa = tarifaRepository.findByTipoVehiculo(tipoVehiculo);
        if (tarifa != null) {
            tarifa.setValorHora(nuevoValor);
            return tarifaRepository.save(tarifa);
        }
        return null;
    }

    public Tarifa obtenerTarifa(TipoVehiculo tipoVehiculo) {
        return tarifaRepository.findByTipoVehiculo(tipoVehiculo);
    }
}