package com.lvportfolio.argpro.Interface;

import com.lvportfolio.argpro.Entity.Experiencia;

import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    public List<Experiencia> list();

    public Optional<Experiencia> getOne(int id);

    public Optional<Experiencia> getByPuesto(String puesto);

    public void save(Experiencia expe);

    public void delete(int id);

    public boolean existsById(int id);

    public boolean existsByPuesto(String puesto);

}
