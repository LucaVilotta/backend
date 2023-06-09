package com.lvportfolio.argpro.Security.Repository;

import com.lvportfolio.argpro.Security.Entity.Rol;
import com.lvportfolio.argpro.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
