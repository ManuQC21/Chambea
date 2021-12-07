package com.chambea.services.util;


import com.chambea.model.Categoria;
import com.chambea.model.Habilidad;

import java.util.List;

public interface HabilidadService {

    Habilidad createHabilidad(Habilidad habilidad);
    List<Habilidad> getAll();
    Habilidad get(Integer id);
    Habilidad updateHabilidad(Habilidad habilidad);
    void deleteHabilidad(Integer id);

    List<Habilidad> getByCategory(Categoria categoria);
}
