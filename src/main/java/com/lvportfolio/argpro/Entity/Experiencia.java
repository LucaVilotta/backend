package com.lvportfolio.argpro.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String puesto;
    private String lugar;

    //Constructores

    public Experiencia() {
    }

    public Experiencia(String puesto, String lugar) {
        this.puesto = puesto;
        this.lugar = lugar;
    }
}
