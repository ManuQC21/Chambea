package com.chambea.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="certificado")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_certificado")
    private Integer idCertificado;

    @OneToOne
    @JoinColumn(
            name = "id_freelancer",
            nullable = false,
            foreignKey = @ForeignKey(name="FK_certificado_freelancer"))
    private Freelancer freelancer;

    @Column(name="proveedor", nullable=false, length=64)
    private String proveedor;

    @Column(name="descripcion", nullable=false, length=64)
    private String descripcion;

    @Column(name="enlace", nullable=true, length=64)
    private String enlace;


}