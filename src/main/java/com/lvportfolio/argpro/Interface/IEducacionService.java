package com.lvportfolio.argpro.Interface;

import com.lvportfolio.argpro.Entity.Educacion;
import java.util.List;


public interface IEducacionService {
    //Traer una lista de educaciones
    public List<Educacion> getEducacion ();

    //Guardar un objeto de tipo educacion
    public void saveEducacion(Educacion educacion);

    //Eliminar un objeto pero lo buscamos por ID

    public void deleteEducacion(Long id);

    //Buscar una persona por ID

    public Educacion findEducacion(Long id);
}
