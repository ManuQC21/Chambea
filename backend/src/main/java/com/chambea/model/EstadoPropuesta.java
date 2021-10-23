package com.chambea.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="estado_propuesta")
public class EstadoPropuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoPropuesta;

    @Column(name="descripcion", nullable = false, length = 264)
    private String descripcion;


}
