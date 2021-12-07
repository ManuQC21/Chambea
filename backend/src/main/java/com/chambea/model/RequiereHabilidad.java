package com.chambea.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="requiere_habilidad")
public class RequiereHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_requiere_habilidad")
    private Integer idRequiereHabilidad;

    @ManyToOne
    @JoinColumn(
            name="id_habilidad",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_requiere_habilidad")
    )
    private Habilidad habilidad;

    @ManyToOne
    @JoinColumn(
            name="id_trabajo",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_requiere_trabajo")
    )
    private Trabajo idTrabajo;
}