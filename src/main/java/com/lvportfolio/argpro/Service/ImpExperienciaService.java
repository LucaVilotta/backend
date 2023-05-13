package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Experiencia;
import com.lvportfolio.argpro.Interface.IExperienciaService;
import com.lvportfolio.argpro.Repository.iExperienciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpExperienciaService implements IExperienciaService {
    @Autowired
    iExperienciaRepository iexperienciaRepository;

    @Override
    public List<Experiencia> list(){
        return iexperienciaRepository.findAll();
    }

    @Override
    public Optional<Experiencia> getOne(int id){
        return iexperienciaRepository.findById(id);
    }

    @Override
    public Optional<Experiencia> getByPuesto(String puesto){
        return iexperienciaRepository.findByPuesto(puesto);
    }


    @Override
    public void save(Experiencia expe){
        iexperienciaRepository.save(expe);
    }

    @Override
    public void delete(int id){
        iexperienciaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id){
        return iexperienciaRepository.existsById(id);
    }

    @Override
    public boolean existsByPuesto(String puesto){
        return iexperienciaRepository.existsByPuesto(puesto);
    }
}
