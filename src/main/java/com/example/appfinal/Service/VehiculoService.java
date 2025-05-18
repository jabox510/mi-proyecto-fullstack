package com.example.appfinal.Service;


import com.example.appfinal.Model.Vehiculo;
import com.example.appfinal.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Vehiculo registrarIngreso(Vehiculo vehiculo) {
        vehiculo.setFechaIngreso(LocalDateTime.now());
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo registrarSalida(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa);
        if (vehiculo != null) {
            vehiculo.setFechaSalida(LocalDateTime.now());
            return vehiculoRepository.save(vehiculo);
        }
        return null;
    }

    public Vehiculo obtenerPorPlaca(String placa) {
        return vehiculoRepository.findByPlaca(placa);
    }
}