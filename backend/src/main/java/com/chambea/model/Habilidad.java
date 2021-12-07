package com.chambea.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="habilidad")
public class Habilidad {

    @Id
    @Column(name = "id_habilidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabilidad;

    @Column(name="descripcion", nullable = false, length = 64)
    private String descripcion;

    @ManyToOne
    @JoinColumn(
            name="id_categoria",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_habilidad_categoria")
    )
    private Categoria idCategoria;

}
