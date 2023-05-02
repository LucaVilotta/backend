package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Educacion;
import com.lvportfolio.argpro.Interface.IEducacionService;
import com.lvportfolio.argpro.Repository.IEducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpEducacionService implements IEducacionService {
    @Autowired IEducacionRepository ieducacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = ieducacionRepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        ieducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        ieducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educacion = ieducacionRepository.findById(id).orElse(null);
        return educacion;
    }
}
