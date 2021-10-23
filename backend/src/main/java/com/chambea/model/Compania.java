package com.chambea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@Table(name="compania")
public class Compania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_inicio", nullable = false)
    private Calendar fecha_inicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_fin", nullable = false)
    private Calendar fecha_fin;
}
