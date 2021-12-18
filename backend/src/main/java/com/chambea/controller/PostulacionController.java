package com.chambea.controller;

import com.chambea.model.Freelancer;
import com.chambea.model.Postulacion;
import com.chambea.model.Trabajo;
import com.chambea.services.PostulacionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("postulaciones")
public class PostulacionController {

    private PostulacionService postulacionService;

    @PostMapping
    public ResponseEntity<Postulacion> create(@RequestBody Postulacion postulacion){
        Postulacion postulacionCreated = this.postulacionService.create(postulacion);
        return new ResponseEntity<>(postulacionCreated, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Postulacion>> getAll(){
        return new ResponseEntity<>(this.postulacionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> get(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.postulacionService.get(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Postulacion> update(@RequestBody Postulacion postulacion){
        Postulacion postulacionCreated = this.postulacionService.update(postulacion);
        return new ResponseEntity<>(postulacionCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        this.postulacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/byFreelancer")
    public ResponseEntity<List<Postulacion>> getByFreelancer(@RequestParam Freelancer freelancer){
        List<Postulacion> postulaciones = this.postulacionService.getByFreelancer(freelancer);
        return new ResponseEntity<>(postulaciones, HttpStatus.OK);
    }

    @GetMapping("/byTrabajo")
    public ResponseEntity<List<Postulacion>> getByFreelancer(@RequestParam Trabajo trabajo){
        List<Postulacion> postulaciones = this.postulacionService.getByTrabajo(trabajo);
        return new ResponseEntity<>(postulaciones, HttpStatus.OK);
    }

}
