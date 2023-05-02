package com.lvportfolio.argpro.Interface;

import com.lvportfolio.argpro.Entity.Habilidad;
import java.util.List;


public interface IHabilidadService {
    //traer una lista de habilidades
    public List<Habilidad> getHabilidad();

    //guardar un objeto del tipo habilidad
    public void saveHabilidad(Habilidad habilidad);

    //eliminar un objeto pero lo buscamos por id
    public void deleteHabilidad(Long id);

    //buscar una habilidad por id
    public Habilidad findHabilidad(Long id);
}
