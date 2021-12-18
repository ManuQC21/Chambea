package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_educacion")
    private Integer idEducacion;

    @Column(name="centroEstudios", nullable = false, length = 64)
    private String centroEstudios;

    @Column(name="titulo", nullable = false, length = 64)
    private String titulo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="fecha_inicio", nullable = false, length = 64)
    private Date fechaInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="fecha_fin", nullable = false, length = 64)
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_educacion_freelancer")
    )
    @JsonBackReference
    private Freelancer idFreelancer;
}
