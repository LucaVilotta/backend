package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Habilidad;
import com.lvportfolio.argpro.Repository.IHabilidadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImpHabilidadService{
    @Autowired
    IHabilidadRepository ihabilidadRepository;

    public List<Habilidad> list(){
        return ihabilidadRepository.findAll();
    }

    public Optional<Habilidad> getOne(int id){
        return ihabilidadRepository.findById(id);
    }

    public Optional<Habilidad> getByHabilidad(String habilidad){
        return ihabilidadRepository.findByHabilidad(habilidad);
    }

    public void save(Habilidad hab){
        ihabilidadRepository.save(hab);
    }

    public void delete(int id){
        ihabilidadRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return ihabilidadRepository.existsById(id);
    }

    public boolean existsByHabilidad(String habilidad){
        return ihabilidadRepository.existsByHabilidad(habilidad);
    }
}
