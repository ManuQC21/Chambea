package com.chambea.services.impl;

import com.chambea.model.Certificado;
import com.chambea.repositories.CertificadoRepository;
import com.chambea.services.CertificadoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CertificadoServiceImpl implements CertificadoService{

    private final CertificadoRepository certificadoRepository;


    @Override
    public Certificado createCertificado(Certificado certificado) {
            return certificadoRepository.save(certificado);
    }

    @Override
    public List<Certificado> getAll(){return this.certificadoRepository.findAll();}

    @Override
    public Certificado UpdateCertificado(Certificado certificado){
        Certificado certificado1 = this.certificadoRepository.save(certificado);
        return certificado1;
    }

    @Override
    public Certificado getCertificado(Integer id) {
        return certificadoRepository.getById(id);
    }

    @Override
    public void deleteCertificado(Integer id){
        this.certificadoRepository.deleteById(id);
    }
}
