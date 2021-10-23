package com.chambea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@Table(name="membresia")
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_membresia")
    private Integer idMembresia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_inicio", nullable = false)
    private Calendar fecha_inicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_fin", nullable = false)
    private Calendar fecha_fin;
}
