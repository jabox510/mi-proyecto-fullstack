package com.example.appfinal.Model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int capacidadMoto;
    private int capacidadCarro;
    private int capacidadBicicleta;

    @OneToMany(mappedBy = "parqueadero")
    private List<Vehiculo> vehiculos;
}