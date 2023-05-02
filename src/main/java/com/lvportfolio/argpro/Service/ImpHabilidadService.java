package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Habilidad;
import com.lvportfolio.argpro.Interface.IHabilidadService;
import com.lvportfolio.argpro.Repository.IHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpHabilidadService implements IHabilidadService {
    @Autowired IHabilidadRepository ihabilidadRepository;

    @Override
    public List<Habilidad> getHabilidad(){
        List<Habilidad> habilidad = ihabilidadRepository.findAll();
        return habilidad;
    }

    @Override
    public void saveHabilidad(Habilidad habilidad){ihabilidadRepository.save(habilidad);}

    @Override
    public void deleteHabilidad(Long id){ihabilidadRepository.deleteById(id);}

    @Override
    public Habilidad findHabilidad(Long id){
        Habilidad habilidad = ihabilidadRepository.findById(id).orElse(null);
        return habilidad;
    }
}
