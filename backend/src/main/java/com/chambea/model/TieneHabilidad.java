package com.chambea.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tiene_habilidad")
public class TieneHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTieneHabilidad;

    @ManyToOne
    @JoinColumn(
            name="id_habilidad",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_tiene_habilidad")
    )
    private Habilidad idHabilidad;

    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_tiene_freelancer")
    )
    private Freelancer freelancer;

}
