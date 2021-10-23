package com.chambea.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="mensaje")
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMensaje;

    @ManyToOne
    @JoinColumn(
            name="id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_mensaje_freelancer")
    )
    private Freelancer idFreelancer;

    @ManyToOne
    @JoinColumn(
            name="id_empleador",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_mensaje_empleador")
    )
    private Empleador idEmpleador;

    @ManyToOne
    @JoinColumn(
            name="id_postulacion",
            nullable = true,
            foreignKey = @ForeignKey(name="FK_mensaje_postulacion")
    )
    private Postulacion postulacion;


}
