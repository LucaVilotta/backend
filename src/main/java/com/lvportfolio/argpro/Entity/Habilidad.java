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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String habilidad;

    private String porcentaje;

    //Constructores

    public Habilidad() {
    }

    public Habilidad(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
}
