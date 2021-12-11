package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="freelancer")
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_freelancer")
    private Integer idFreelancer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name="titulo", nullable=false, length=64)
    private String titulo;

    @Column(name="descripcion", nullable=false, length=64)
    private String descripcion;

    @JsonIgnore
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
    private List<Educacion> educacion;

    @OneToMany(
            mappedBy = "idFreelancer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ExperienciaLaboral> experienciaLaboral;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "freelancer",
            fetch = FetchType.LAZY
    )
    private List<TieneHabilidad> habilidades;




}
