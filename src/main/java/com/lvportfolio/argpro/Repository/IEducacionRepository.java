package com.lvportfolio.argpro.Repository;

import com.lvportfolio.argpro.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion> findByInstitucion(String educacion);
    public boolean existsByInstitucion(String educacion);
}
