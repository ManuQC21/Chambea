package com.chambea.controller;

import com.chambea.model.Habilidad;
import com.chambea.services.util.HabilidadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidades")
@AllArgsConstructor
public class HabilidadController {

    private final HabilidadService habilidadService;

    @PostMapping
    public ResponseEntity<Habilidad> createHabilidad(@RequestBody Habilidad habilidad){
        Habilidad habilidad1 = this.habilidadService.createHabilidad(habilidad);
        return new ResponseEntity<>(habilidad1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Habilidad>> getAll(){
        return new ResponseEntity<>(this.habilidadService.getAll(), HttpStatus.OK);
    }
}
