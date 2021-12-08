package com.chambea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="requiere_habilidad")
public class RequiereHabilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_requiere_habilidad")
    private Integer idRequiereHabilidad;

    @ManyToOne
    @JoinColumn(
            name="id_habilidad",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_requiere_habilidad")
    )
    private Habilidad habilidad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name="id_trabajo",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_requiere_trabajo")
    )
    private Trabajo idTrabajo;
}