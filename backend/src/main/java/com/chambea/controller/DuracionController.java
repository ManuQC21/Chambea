package com.chambea.controller;

import com.chambea.model.Duracion;
import com.chambea.repositories.DuracionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duraciones")
@AllArgsConstructor
public class DuracionController {

    private DuracionRepository duracionRepository;


    @GetMapping
    public ResponseEntity<List<Duracion>> getAll(){
        return new ResponseEntity<List<Duracion>>(this.duracionRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Duracion> createDuracion(@RequestBody Duracion duracion){
        return new ResponseEntity<>(this.duracionRepository.save(duracion), HttpStatus.CREATED);
    }


}
