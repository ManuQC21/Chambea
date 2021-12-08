package com.chambea.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private Duracion duracion;

    @ManyToOne
    @JoinColumn(
            name="id_empleador",
            nullable = false,
            foreignKey=@ForeignKey(name="FK_trabajo_empleador")
    )
    private Empleador empleador;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "idTrabajo",
            fetch = FetchType.LAZY
    )
    //private Set<RequiereHabilidad> habilidades;
    private List<RequiereHabilidad> habilidades;


}
