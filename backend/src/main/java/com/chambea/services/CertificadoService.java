package com.chambea.services;

import com.chambea.model.Certificado;

import java.util.List;

public interface CertificadoService {
    Certificado createCertificado(Certificado certificado);
    List<Certificado> getAll();
    Certificado UpdateCertificado(Certificado certificado);
    Certificado getCertificado(Integer id);
    void deleteCertificado(Integer id);
}
