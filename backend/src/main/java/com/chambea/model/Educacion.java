package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @Column(name="id_educacion")
    private Integer idEducacion;

    @Column(name="universidad", nullable = false, length = 64)
    private String universidad;

    @Column(name="titulo", nullable = false, length = 64)
    private String titulo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_educacion_freelancer")
    )
    private Freelancer idFreelancer;
}
