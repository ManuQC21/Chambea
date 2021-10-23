package com.chambea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
@Table(name="freelancer")
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_freelancer")
    private Integer idFreelancer;

    @OneToOne
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_freelancer_usuario"))
    private Usuario usuario;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_registro", nullable = false)
    private Calendar fechaRegistro;


    @Column(name="descripcion", nullable=false, length=64)
    private String descripcion;

}