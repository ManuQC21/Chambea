package com.chambea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateFreelancerRequest {

    private Integer idUsuario;
    private String titulo;
    private String descripcion;
}
