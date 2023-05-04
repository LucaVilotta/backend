package com.lvportfolio.argpro.Security.Service;

import com.lvportfolio.argpro.Security.Entity.Rol;
import com.lvportfolio.argpro.Security.Enums.RolNombre;
import com.lvportfolio.argpro.Security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){

        irolRepository.save(rol);
    }
}
