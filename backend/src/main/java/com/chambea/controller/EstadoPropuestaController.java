package com.chambea.controller;

import com.chambea.model.EstadoPropuesta;
import com.chambea.services.EstadoPropuestaService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estado-propuesta")
@AllArgsConstructor
public class EstadoPropuestaController {

    private EstadoPropuestaService estadoPropuestaService;

    @PostMapping
    public ResponseEntity<EstadoPropuesta> create(@RequestBody EstadoPropuesta estadoPropuesta){
        EstadoPropuesta estadoPropuestaCreated = this.estadoPropuestaService.createEstadoPropuesta(estadoPropuesta);
        return new ResponseEntity<>(estadoPropuestaCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EstadoPropuesta>> getAll(){
        return new ResponseEntity<>(this.estadoPropuestaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPropuesta> getById(@PathVariable Integer id){
        EstadoPropuesta estadoPropuesta = this.estadoPropuestaService.getEstadoPropuesta(id);
        return new ResponseEntity<>(estadoPropuesta, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EstadoPropuesta> update(@RequestBody EstadoPropuesta estadoPropuesta){
        EstadoPropuesta estadoPropuestaCreated = this.estadoPropuestaService.createEstadoPropuesta(estadoPropuesta);
        return new ResponseEntity<>(estadoPropuestaCreated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.estadoPropuestaService.deleteEstadoPropuesta(id);
        return new ResponseEntity(HttpStatus.OK);
    }






}
