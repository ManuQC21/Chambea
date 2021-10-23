package com.chambea.services.impl;

import com.chambea.model.Membresia;
import com.chambea.repositories.MembresiaRepository;
import com.chambea.services.MembresiaServices;
import org.springframework.stereotype.Service;

@Service
public class MembresiaServiceslmpl implements MembresiaServices {

    private MembresiaRepository membresiaRepository;

    MembresiaServiceslmpl(MembresiaRepository membresiaRepository) {this.membresiaRepository = membresiaRepository;}

    @Override
    public Membresia registrarMembresia(Membresia membresia) {return membresiaRepository.save(membresia);}

    @Override
    public void eliminarMembresia(Integer idMembresia) {

    }
}
