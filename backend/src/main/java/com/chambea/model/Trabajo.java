package com.chambea.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name="trabajo")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTrabajo;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 256)
    private String descripcion;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha", nullable = true)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(
            name = "id_duracion",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_trabajo_duracion")
    )
    private Duracion duracion;

    @ManyToOne
    @JoinColumn(
            name = "id_empleador",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_trabajo_empleador")
    )
    private Empleador empleador;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "idTrabajo",
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    //private Set<RequiereHabilidad> habilidades;
    private List<RequiereHabilidad> habilidades;


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "trabajo",
            fetch = FetchType.LAZY
    )
    private List<Postulacion> postulaciones;
}

