package com.lvportfolio.argpro.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String campo; /*puedo volar el campo a la mierda*/

    private String habilidad;

    private String porcentaje;

}
