package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timespan;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Data
@Table(name="postulacion")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPostulacion;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_postulacion_freelancer")
    )
    private Freelancer freelancer;

    @JsonIgnore
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
