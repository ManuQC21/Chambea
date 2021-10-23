package com.chambea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
@Table(name="empleador")
public class Empleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleador")
    private Integer idEmpleador;

    @OneToOne
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_empleador_usuario"))
    private Usuario usuario;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_registro", nullable = false)
    private Calendar fechaRegistro;

    @ManyToOne
    @JoinColumn(
            name="id_compania",
            nullable = true,
            foreignKey = @ForeignKey(name="FK_empleador_compania")
    )
    private Compania compania;


}