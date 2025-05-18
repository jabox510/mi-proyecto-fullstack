package com.example.appfinal.Controller;

import com.example.appfinal.Model.Tarifa;
import com.example.appfinal.Model.TipoVehiculo;
import com.example.appfinal.Service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    @PutMapping("/{tipoVehiculo}")
    public ResponseEntity<Tarifa> cambiarTarifa(@PathVariable TipoVehiculo tipoVehiculo, @RequestBody Double nuevoValor) {
        Tarifa tarifaActualizada = tarifaService.cambiarTarifa(tipoVehiculo, nuevoValor);
        if (tarifaActualizada != null) {
            return ResponseEntity.ok(tarifaActualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{tipoVehiculo}")
    public ResponseEntity<Tarifa> obtenerTarifa(@PathVariable TipoVehiculo tipoVehiculo) {
        Tarifa tarifa = tarifaService.obtenerTarifa(tipoVehiculo);
        if (tarifa != null) {
            return ResponseEntity.ok(tarifa);
        }
        return ResponseEntity.notFound().build();
    }
}