package com.lvportfolio.argpro.Repository;

import com.lvportfolio.argpro.Entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer> {
    public Optional<Habilidad> findByHabilidad(String habilidad);
    public boolean existsByHabilidad(String habilidad);
}
