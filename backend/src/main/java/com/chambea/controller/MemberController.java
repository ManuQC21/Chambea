package com.chambea.controller;


import com.chambea.model.Membresia;
import com.chambea.model.Usuario;
import com.chambea.services.MembresiaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MembresiaServices membresiaServices;

    public MemberController(MembresiaServices membresiaServices) {
        this.membresiaServices = membresiaServices;
    }
    @PostMapping
    public ResponseEntity<Membresia> registrarMembresia(@Valid @RequestBody Membresia membresia){
        Membresia membresiaNew = this.membresiaServices.registrarMembresia(membresia);
        return new ResponseEntity<Membresia>(membresiaNew, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Membresia> obtenerMembresia(
            @RequestParam Integer id
    ){
        Membresia membresia = membresiaServices.obtenerMembresiaPorId(id).get();
        return new ResponseEntity<Membresia>(membresia, HttpStatus.OK);
    }

}
