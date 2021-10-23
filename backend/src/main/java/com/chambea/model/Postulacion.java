package com.chambea.model;

import jdk.jfr.Timespan;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@Table(name="postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPostulacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;

    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_postulacion_freelancer")
    )
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(
            name="id_trabajo",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_postulacion_trabajo")
    )
    private Trabajo trabajo;

    @ManyToOne
    @JoinColumn(
            name="id_estado_propuesta",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_postulacion_estado")
    )
    private EstadoPropuesta estado;

}
