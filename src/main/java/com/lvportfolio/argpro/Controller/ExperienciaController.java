package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Entity.Experiencia;
import com.lvportfolio.argpro.Interface.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    IExperienciaService iexperienciaService;

    @GetMapping("experiencia/traer")
    public List<Experiencia> getExperiencia(){return iexperienciaService.getExperiencia();}

    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        iexperienciaService.saveExperiencia(experiencia);
        return "La experiencia fué creada correctamente";
    }

    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        iexperienciaService.deleteExperiencia(id);
        return "La experiencia fué eliminada correctamente";
    }

    //URL: PUERTO/personas/editar/id/nombre & apellido & img
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                                   @RequestBody Experiencia experiencia){
        Experiencia oldExperiencia = iexperienciaService.findExperiencia(id);


        oldExperiencia.setPuesto(experiencia.getPuesto());
        oldExperiencia.setLugar(experiencia.getLugar());

        iexperienciaService.saveExperiencia(oldExperiencia);
        return oldExperiencia;
    }
}
