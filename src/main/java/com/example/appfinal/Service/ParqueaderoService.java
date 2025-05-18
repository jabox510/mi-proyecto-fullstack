package com.example.appfinal.Service;

import com.example.appfinal.Model.Parqueadero;
import com.example.appfinal.Repository.ParqueaderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParqueaderoService {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    public Parqueadero actualizarCupos(Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }
}