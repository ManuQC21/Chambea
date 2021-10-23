package com.chambea.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="habilidad")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabilidad;

    @Column(name="descripcion", nullable = false, length = 64)
    private String descripcion;

}
