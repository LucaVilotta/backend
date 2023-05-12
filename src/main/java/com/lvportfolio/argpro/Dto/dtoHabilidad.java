package com.lvportfolio.argpro.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoHabilidad {
    @NotBlank
    private String habilidad;
    @NotBlank
    private String porcentaje;

    //Constructor

    public dtoHabilidad() {
    }

    public dtoHabilidad(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    //Getters y Setters


    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
}
