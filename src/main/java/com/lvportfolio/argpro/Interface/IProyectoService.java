package com.lvportfolio.argpro.Interface;

import com.lvportfolio.argpro.Entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    //traer una lista de proyectos
    public List<Proyecto> getProyecto();

    //guardar un objeto del tipo proyecto
    public void saveProyecto(Proyecto proyecto);

    //eliminar un objeto pero lo buscamos por id
    public void deleteProyecto(Long id);

    //buscar un proyecto por id
    public Proyecto findProyecto(Long id);
}
