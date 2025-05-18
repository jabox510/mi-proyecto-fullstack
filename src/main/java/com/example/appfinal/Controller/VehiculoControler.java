package com.example.appfinal.Controller;

import com.example.appfinal.Model.Vehiculo;
import com.example.appfinal.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoControler {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<Vehiculo> registrarIngreso(@RequestBody Vehiculo vehiculo) {
        Vehiculo vehiculoGuardado = vehiculoService.registrarIngreso(vehiculo);
        return ResponseEntity.ok(vehiculoGuardado);
    }

    @PutMapping("/{placa}/salida")
    public ResponseEntity<Vehiculo> registrarSalida(@PathVariable String placa) {
        Vehiculo vehiculo = vehiculoService.registrarSalida(placa);
        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Vehiculo> obtenerVehiculo(@PathVariable String placa) {
        Vehiculo vehiculo = vehiculoService.obtenerPorPlaca(placa);
        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        }
        return ResponseEntity.notFound().build();
    }
}