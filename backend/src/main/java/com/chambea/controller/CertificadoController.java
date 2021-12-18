package com.chambea.controller;

import com.chambea.model.Certificado;
import com.chambea.services.CertificadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/certificado")
public class CertificadoController{

    CertificadoService certificadoService;

    CertificadoController(CertificadoService certificadoService){
        this.certificadoService = certificadoService;
    }

    @PostMapping
    public ResponseEntity<Certificado> createCertificado(@RequestBody Certificado certificado){
        Certificado certificado1 = this.certificadoService.createCertificado(certificado);
        return new ResponseEntity<Certificado>(certificado1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Certificado>> getAll(){
        return new ResponseEntity<List<Certificado>>(this.certificadoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificado> get(@PathVariable("id") Integer id){
        Certificado certificado = this.certificadoService.getCertificado(id);
        return new ResponseEntity<Certificado>(certificado, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Certificado> updateFreelancer(@RequestBody Certificado certificado){
        Certificado certificado1 = this.certificadoService.UpdateCertificado(certificado);
        return new ResponseEntity<Certificado>(certificado1, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Certificado> deleteFreelancer(@RequestParam Integer id){
        this.certificadoService.deleteCertificado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/prueba")
    public ResponseEntity<String> pruebaResponse(){
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
