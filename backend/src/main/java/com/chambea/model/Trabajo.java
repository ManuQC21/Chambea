package com.chambea.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="trabajo")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrabajo;

    @Column(name="descripcion", nullable = false, length = 256)
    private String descripcion;

    @ManyToOne
    @JoinColumn(
            name="id_duracion",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_trabajo_duracion")
    )
    private Duracion duracion;
}
