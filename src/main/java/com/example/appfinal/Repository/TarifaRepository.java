package com.example.appfinal.Repository;



import com.example.appfinal.Model.Tarifa;
import com.example.appfinal.Model.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    Tarifa findByTipoVehiculo(TipoVehiculo tipoVehiculo);
}
