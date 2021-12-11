package com.chambea.controller;

import com.chambea.model.Duracion;
import com.chambea.model.Empleador;
import com.chambea.model.Trabajo;
import com.chambea.services.TrabajoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabajos")
public class TrabajoController {

    private final TrabajoService trabajoService;

    public TrabajoController(TrabajoService trabajoService) {
        this.trabajoService = trabajoService;
    }

    @PostMapping
    public ResponseEntity<Trabajo> createTrabajo(@RequestBody Trabajo trabajo) {
        Trabajo savedTrabajo = this.trabajoService.createTrabajo(trabajo);
        return new ResponseEntity<Trabajo>(savedTrabajo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Trabajo>> getAll(){
        return new ResponseEntity<List<Trabajo>>(this.trabajoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/byEmployer")
    public ResponseEntity<List<Trabajo>> getTrabajoByEmployer(@RequestParam Empleador empleador) {
        List<Trabajo> trabajos = this.trabajoService.getByEmpleador(empleador);
        ResponseEntity response = new ResponseEntity<List<Trabajo>>(trabajos, HttpStatus.OK );
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajo> get(@PathVariable("id") Integer id){
        Trabajo trabajo = this.trabajoService.getTrabajo(id);
        return new ResponseEntity<Trabajo>(trabajo, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Trabajo> updateTrabajo(@RequestBody Trabajo trabajo){
        Trabajo trabajo1 = this.trabajoService.updateTrabajo(trabajo);
        return new ResponseEntity<Trabajo>(trabajo1, HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteTrabajo(@PathVariable("id") Integer id){
        this.trabajoService.deleteTrabajo(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/duraciones")
    public ResponseEntity<List<Duracion>> getDuraciones(){
        List<Duracion> duraciones = this.trabajoService.getDuraciones();
        return new ResponseEntity<>(duraciones, HttpStatus.OK);
    }
}
