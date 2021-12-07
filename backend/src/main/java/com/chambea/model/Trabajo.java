package com.chambea.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="trabajo")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrabajo;

    @Column(name="titulo",nullable = false, length = 100)
    private String titulo;

    @Column(name="descripcion", nullable = false, length = 256)
    private String descripcion;

    @ManyToOne
    @JoinColumn(
            name="id_duracion",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_trabajo_duracion")
    )
    private Duracion idDuracion;

    @ManyToOne
    @JoinColumn(
            name="id_empleador",
            nullable = false,
            foreignKey=@ForeignKey(name="FK_trabajo_empleador")
    )
    private Empleador idEmpleador;

    @OneToMany(
            mappedBy = "idTrabajo"
    )
    private Set<RequiereHabilidad> habilidades;


}
