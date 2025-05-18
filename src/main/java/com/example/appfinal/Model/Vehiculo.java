package com.example.appfinal.Model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVehiculo tipo;

    @Column(nullable = false)
    private LocalDateTime fechaIngreso;

    private LocalDateTime fechaSalida;

    @ManyToOne
    @JoinColumn(name = "parqueadero_id")
    private Parqueadero parqueadero;
}