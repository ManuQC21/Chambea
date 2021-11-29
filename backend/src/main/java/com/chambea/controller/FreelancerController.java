package com.chambea.controller;

import com.chambea.model.Freelancer;
import com.chambea.services.FreelancerService;
import com.chambea.services.impl.FreelancerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freelancer")
public class FreelancerController {

    FreelancerService freelancerService;

    FreelancerController(FreelancerService freelancerService){
        this.freelancerService = freelancerService;
    }

    @PostMapping
    public ResponseEntity<Freelancer> createFreelancer(@RequestBody Freelancer freelancer){
        Freelancer free = this.freelancerService.registrarFreelancer(freelancer);
        return new ResponseEntity<Freelancer>(free, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Freelancer>> getAll(){
        return new ResponseEntity<List<Freelancer>>(this.freelancerService.listarFreelancers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Freelancer> get(@PathVariable("id") Integer id){
        Freelancer freelancer = this.freelancerService.obtenerPorId(id);
        return new ResponseEntity<Freelancer>(freelancer, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Freelancer> updateFreelancer(@RequestParam Freelancer freelancer){
        Freelancer freelancer1 = this.freelancerService.actualizarFreelancer(freelancer);
        return new ResponseEntity<Freelancer>(freelancer1, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Freelancer> deleteFreelancer(@RequestParam Integer id){
        this.freelancerService.eliminarFreelancer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/prueba")
    public ResponseEntity<String> pruebaResponse(){
        return new ResponseEntity<String>("Hola",HttpStatus.OK);
    }
}
