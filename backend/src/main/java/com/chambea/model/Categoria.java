package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer idCategoria;

    @Column(name = "descripcion")
    private String descripcion;

    @JsonIgnore
    @OneToMany(
            mappedBy = "idCategoria"
    )
    private Set<Habilidad> habilidades;
}
