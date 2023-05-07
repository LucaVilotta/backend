package com.lvportfolio.argpro.Dto;

import jakarta.validation.constraints.NotBlank;



public class dtoExperiencia {
    @NotBlank
    private String puesto;
    @NotBlank
    private String lugar;

    //Constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String puesto, String lugar) {
        this.puesto = puesto;
        this.lugar = lugar;
    }

    //Getters y Setters


    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
