package com.lvportfolio.argpro.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucion;
    private String titulo;
    
    //Constructores

    public Educacion() {
    }

    public Educacion(String institucion, String titulo) {
        this.institucion = institucion;
        this.titulo = titulo;
    }
}
