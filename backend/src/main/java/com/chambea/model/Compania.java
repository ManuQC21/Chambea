package com.chambea.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@Table(name="compania")
public class Compania {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compania")
    private Integer idCompania;

    @Column(name="nombre", nullable = false, length = 64)
    private String nombre;

}
