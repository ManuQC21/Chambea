package com.chambea.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    @Column(name="calificacion",nullable = false,length = 30)
    private String calificacion;

    @Size(min=14, message = "El comentario debe tener mínimo 14 caracteres")
    @Column(name="comentario", nullable = false, length = 256)
    private String comentario;

    @ManyToOne
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_freelancer_usuario"))
    private Usuario usuario;
}