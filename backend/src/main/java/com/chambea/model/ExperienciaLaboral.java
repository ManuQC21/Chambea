package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "experiencia_laboral")
public class ExperienciaLaboral {

    @Id
    @Column(name="id_experiencia_laboral")
    private Integer idExperienciaLaboral;

    @Column(name="titulo", nullable = false, length = 64)
    private String titulo;

    @Column(name="fecha_inicio", nullable = false, length = 64)
    private Date fechaInicio;

    @Column(name="fecha_fin", nullable = false, length = 64)
    private Date fechaFin;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_experiencia_freelancer")
    )
    private Freelancer idFreelancer;

}
