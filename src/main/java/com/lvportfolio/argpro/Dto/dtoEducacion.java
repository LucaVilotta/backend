package com.lvportfolio.argpro.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoEducacion {
    
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;

    //Constructor
    
    public dtoEducacion() {
    }

    public dtoEducacion(String institucion, String titulo) {
        this.institucion = institucion;
        this.titulo = titulo;
    }
    
    //Getters and setters

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    


    
}
