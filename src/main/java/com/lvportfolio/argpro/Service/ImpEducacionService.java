package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Educacion;
import com.lvportfolio.argpro.Repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpEducacionService{
    @Autowired IEducacionRepository ieducacionRepository;

    public List<Educacion> list(){
        return ieducacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id){
        return ieducacionRepository.findById(id);
    }

    public Optional<Educacion> getByInstitucion(String educacion){
        return ieducacionRepository.findByInstitucion(educacion);
    }

    public void save(Educacion edu){
        ieducacionRepository.save(edu);
    }

    public void delete(int id){
        ieducacionRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return ieducacionRepository.existsById(id);
    }

    public boolean existsByInstitucion(String educacion){
        return ieducacionRepository.existsByInstitucion(educacion);
    }
}
