package com.example.appfinal.Controller;

import com.example.appfinal.Model.Parqueadero;
import com.example.appfinal.Service.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parqueaderos")
public class ParqueaderoController {

    @Autowired
    private ParqueaderoService parqueaderoService;


    @PostMapping
    public ResponseEntity<Parqueadero> crearParqueadero(@RequestBody Parqueadero parqueadero) {
        Parqueadero creado = parqueaderoService.actualizarCupos(parqueadero);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parqueadero> actualizarCupos(@PathVariable Long id, @RequestBody Parqueadero parqueadero) {
        parqueadero.setId(id);
        Parqueadero parqueaderoActualizado = parqueaderoService.actualizarCupos(parqueadero);
        return ResponseEntity.ok(parqueaderoActualizado);
    }
}