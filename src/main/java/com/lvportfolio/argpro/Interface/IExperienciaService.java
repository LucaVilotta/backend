package com.lvportfolio.argpro.Interface;

import com.lvportfolio.argpro.Entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    //Traer una lista de experencias
    public List<Experiencia> getExperiencia ();

    //Guardar un objeto de tipo experiencia
    public void saveExperiencia(Experiencia experiencia);

    //Eliminar un objeto pero lo buscamos por ID
    public void deleteExperiencia(Long id);

    //Buscar una persona por ID

    public Experiencia findExperiencia(Long id);
}
