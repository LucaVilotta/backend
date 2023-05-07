package com.lvportfolio.argpro.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
}
