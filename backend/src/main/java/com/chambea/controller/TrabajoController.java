package com.chambea.controller;

import com.chambea.model.Trabajo;
import com.chambea.services.TrabajoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajo")
public class TrabajoController {

    private final TrabajoService trabajoService;

    public TrabajoController(TrabajoService trabajoService) {
        this.trabajoService = trabajoService;
    }

    @PostMapping
    public ResponseEntity<Trabajo> createTrabajo(@RequestBody Trabajo trabajo) {
        Trabajo savedTrabajo = this.trabajoService.resgitrarTrabajo(trabajo);
        return new ResponseEntity<Trabajo>(savedTrabajo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Trabajo>> getAll(){
        return new ResponseEntity<List<Trabajo>>(this.trabajoService.listarTrabajos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajo> get(@PathVariable("id") Integer id){
        Trabajo trabajo = this.trabajoService.obtenerPorId(id);
        return new ResponseEntity<Trabajo>(trabajo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Trabajo> updateTrabajo(@RequestBody Trabajo trabajo){
        Trabajo trabajo1 = this.trabajoService.modificarTrabajo(trabajo);
        return new ResponseEntity<Trabajo>(trabajo1, HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteTrabajo(@PathVariable("id") Integer id){
        this.trabajoService.eliminarTrabajo(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
