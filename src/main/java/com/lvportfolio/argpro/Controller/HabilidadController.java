package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Entity.Habilidad;
import com.lvportfolio.argpro.Interface.IHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {
    @Autowired
    IHabilidadService ihabilidadService;

    @GetMapping("habilidad/traer")
    public List<Habilidad> getHabilidad(){return ihabilidadService.getHabilidad();}

    @PostMapping("/habilidad/crear")
    public String createHabilidad(@RequestBody Habilidad habilidad){
        ihabilidadService.saveHabilidad(habilidad);
        return "La habilidad fué creada correctamente";
    }

    @DeleteMapping("/habilidad/borrar/{id}")
    public String deleteHabilidad(@PathVariable Long id){
        ihabilidadService.deleteHabilidad(id);
        return "La habilidad fué eliminada correctamente";
    }

    //URL: PUERTO/personas/editar/id/
    @PutMapping("/habilidad/editar/{id}")
    public Habilidad editHabilidad(@PathVariable Long id,
                                       @RequestBody Habilidad habilidad){
        Habilidad oldHabilidad = ihabilidadService.findHabilidad(id);


        oldHabilidad.setCampo(habilidad.getCampo());
        oldHabilidad.setHabilidad(habilidad.getHabilidad());
        oldHabilidad.setPorcentaje(habilidad.getPorcentaje());
        ihabilidadService.saveHabilidad(oldHabilidad);
        return oldHabilidad;
    }
}
