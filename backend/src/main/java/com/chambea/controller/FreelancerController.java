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
    public ResponseEntity<Freelancer> registrarFreelancer(@RequestBody Freelancer freelancer){
        Freelancer free = this.freelancerService.registrarFreelancer(freelancer);
        return new ResponseEntity<Freelancer>(free, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Freelancer> obtenerPorId(@RequestParam Integer id){
        Freelancer freelancer = this.freelancerService.obtenerPorId(id);
        return new ResponseEntity<Freelancer>(freelancer, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Freelancer>> listarFreelancers(){
        return new ResponseEntity<List<Freelancer>>(this.freelancerService.listarFreelancers(), HttpStatus.OK);
    }
}
