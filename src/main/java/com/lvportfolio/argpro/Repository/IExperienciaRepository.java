package com.lvportfolio.argpro.Repository;

import com.lvportfolio.argpro.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
}
