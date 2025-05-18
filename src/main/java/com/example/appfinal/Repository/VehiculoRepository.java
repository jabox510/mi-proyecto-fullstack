package com.example.appfinal.Repository;

import com.example.appfinal.Model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Vehiculo findByPlaca(String placa);
}