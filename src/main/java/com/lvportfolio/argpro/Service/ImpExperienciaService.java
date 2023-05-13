package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Experiencia;
import com.lvportfolio.argpro.Repository.iExperienciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpExperienciaService{
    @Autowired
    iExperienciaRepository iexperienciaRepository;

    public List<Experiencia> list(){
        return iexperienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id){
        return iexperienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByPuesto(String puesto){
        return iexperienciaRepository.findByPuesto(puesto);
    }

    public void save(Experiencia expe){
        iexperienciaRepository.save(expe);
    }

    public void delete(int id){
        iexperienciaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return iexperienciaRepository.existsById(id);
    }

    public boolean existsByPuesto(String puesto){
        return iexperienciaRepository.existsByPuesto(puesto);
    }
}
