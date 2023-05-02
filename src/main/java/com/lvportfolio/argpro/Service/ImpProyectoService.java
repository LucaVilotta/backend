package com.lvportfolio.argpro.Service;

import com.lvportfolio.argpro.Entity.Proyecto;
import com.lvportfolio.argpro.Interface.IProyectoService;
import com.lvportfolio.argpro.Repository.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProyectoService implements IProyectoService {
    @Autowired IProyectoRepository iproyectoRepository;

    @Override
    public List<Proyecto> getProyecto(){
        List<Proyecto> proyecto = iproyectoRepository.findAll();
        return proyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto){iproyectoRepository.save(proyecto);}

    @Override
    public void deleteProyecto(Long id){iproyectoRepository.deleteById(id);}

    @Override
    public Proyecto findProyecto(Long id){
        Proyecto proyecto = iproyectoRepository.findById(id).orElse(null);
        return proyecto;
    }
}
