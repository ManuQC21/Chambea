package com.chambea.controller;

import com.chambea.model.Educacion;
import com.chambea.services.EducacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
public class EducacionController {
    private final EducacionService educacionService;

    public EducacionController(EducacionService educacionService){
        this.educacionService = educacionService;
    }

    @PostMapping
    public ResponseEntity<Educacion> createEducacion(@RequestBody Educacion educacion){
        Educacion savedEducacion = this.educacionService.createEducacion(educacion);
        return new ResponseEntity<Educacion>(savedEducacion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Educacion>> getAll(){
        return new ResponseEntity<List<Educacion>>(this.educacionService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Educacion> updateEducacion(@RequestBody Educacion educacion){
        Educacion educacion1 = this.educacionService.updateEducacion(educacion);
        return new ResponseEntity<Educacion>(educacion1, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEducacion(@RequestParam("id") Integer id){
        this.educacionService.deleteEducacion(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
