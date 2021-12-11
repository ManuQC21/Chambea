package com.chambea.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq_gen")
    @Column(name = "id")
    private Integer idUsuario;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NotEmpty(message = "¡El cuerpo del comentario no puede estar vacío! Escribe algo cuerdo por amor a Internet, ¿quieres?")
    private String body;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name="Comentario", nullable = false, length = 256)
    private String comentario;

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + idUsuario +
                ", body='" + body + '\'' +
                ", creationDate=" + creationDate    +
                '}';
    }


}