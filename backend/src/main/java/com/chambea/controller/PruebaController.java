package com.chambea.controller;

import com.chambea.model.Categoria;
import com.chambea.model.Habilidad;
import com.chambea.repositories.CategoriaRepository;
import com.chambea.services.util.HabilidadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class PruebaController {

    private final HabilidadService habilidadService;
    private final CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Habilidad>> getByCategory(@RequestParam Categoria categoria){
        return new ResponseEntity<>(this.habilidadService.getByCategory(categoria), HttpStatus.OK);
    }

    @GetMapping("/cat")
    public ResponseEntity<List<Categoria>> getCat(){
        List<Categoria> cats = this.categoriaRepository.findAll();
        ResponseEntity<List<Categoria>> res = new ResponseEntity(cats, HttpStatus.OK);
        return res;
    }

}
