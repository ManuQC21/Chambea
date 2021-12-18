package com.chambea.controller;

import com.chambea.model.Empleador;
import com.chambea.model.ExperienciaLaboral;
import com.chambea.model.Freelancer;
import com.chambea.model.Trabajo;
import com.chambea.services.ExperienciaLaboralService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experienciaLab")
public class ExperienciaLaboralController {

    ExperienciaLaboralService experienciaLaboralService;

    ExperienciaLaboralController(ExperienciaLaboralService experienciaLaboralService){
        this.experienciaLaboralService = experienciaLaboralService;
    }

    @PostMapping
    public ResponseEntity<ExperienciaLaboral> createExplab(@RequestBody ExperienciaLaboral experienciaLaboral) {
        ExperienciaLaboral exp = this.experienciaLaboralService.createExperienciaLaboral(experienciaLaboral);
        return new ResponseEntity<ExperienciaLaboral>(exp, HttpStatus.CREATED);
    }

    @GetMapping("/byFreelancer")
    public ResponseEntity<List<ExperienciaLaboral>> getExByFree(@RequestParam Freelancer freelancer) {
        List<ExperienciaLaboral> exp1 = this.experienciaLaboralService.listByFree(freelancer);
        ResponseEntity response = new ResponseEntity<List<ExperienciaLaboral>>(exp1, HttpStatus.OK );
        return response;
    }
    @PutMapping
    public ResponseEntity<ExperienciaLaboral> updateExp(@RequestBody ExperienciaLaboral experienciaLaboral){
        ExperienciaLaboral exp2 = this.experienciaLaboralService.upadteExperienciaLaboral(experienciaLaboral);
        return new ResponseEntity<ExperienciaLaboral>(exp2, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteTrabajo(@RequestParam Integer id){
        this.experienciaLaboralService.deleteExperienciaLaboral(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
