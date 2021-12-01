package com.chambea.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String username;
    private String email;
    private String nombres;
    private String apellidos;
    private String password;
    private String rePassword;
}
