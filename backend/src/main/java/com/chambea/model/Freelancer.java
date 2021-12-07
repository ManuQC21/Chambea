package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Data
@Entity
@Table(name="freelancer")
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_freelancer")
    private Integer idFreelancer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_registro", nullable = false)
    private Calendar fechaRegistro;

    @Column(name="titulo", nullable=false, length=64)
    private String titulo;

    @Column(name="descripcion", nullable=false, length=64)
    private String descripcion;

    @OneToOne(
            //fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_freelancer_usuario"))
    private Usuario usuario;

    @OneToMany(
            mappedBy = "idFreelancer"
    )
    private Set<Educacion> educacion;

    @OneToMany(
            mappedBy = "idFreelancer"
    )
    private Set<ExperienciaLaboral> experienciaLaboral;




}
