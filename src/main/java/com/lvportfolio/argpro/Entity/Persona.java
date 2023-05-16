package com.lvportfolio.argpro.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud" )
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud" )
    private String apellido;

    private String img;

    private String sobreMi;

    private String especializacion;
    
    //Constructores

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String sobreMi, String especializacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.sobreMi = sobreMi;
        this.especializacion = especializacion;
    }
}
