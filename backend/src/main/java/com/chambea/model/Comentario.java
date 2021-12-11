package com.chambea.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name = "comments")
public class Comentario {

    @Id
    @Size(min=4, message = "El comentario debe tener mínimo 24 caracteres")
    @Column(name="comentario", nullable = false, length = 256)

    private String comentario;



}