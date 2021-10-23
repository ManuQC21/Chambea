package com.chambea.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="duracion")
public class Duracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDuracion;

    @Column(name="descripcion", nullable = false, length = 256)
    private String descripcion;
}
