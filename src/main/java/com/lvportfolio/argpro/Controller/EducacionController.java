package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Entity.Educacion;
import com.lvportfolio.argpro.Interface.IEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://portfolio-frontend-luca.web.app")
public class EducacionController {
    @Autowired IEducacionService ieducacionService;

    @GetMapping("educacion/traer")
    public List<Educacion> getEducacion(){return ieducacionService.getEducacion();}

    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        ieducacionService.saveEducacion(educacion);
        return "La educación fué creada correctamente";
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        ieducacionService.deleteEducacion(id);
        return "La educación fué eliminada correctamente";
    }

    //URL: PUERTO/personas/editar/id/nombre & apellido & img
    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
                                   @RequestBody Educacion educacion){
        Educacion oldEducacion = ieducacionService.findEducacion(id);


        oldEducacion.setInstitucion(educacion.getInstitucion());
        oldEducacion.setTitulo(educacion.getTitulo());

        ieducacionService.saveEducacion(oldEducacion);
        return oldEducacion;
    }

    @GetMapping("/educacion/traer/perfil") /*Esto no se pq está acá xd*/
    public Educacion findEducacion(){
        return ieducacionService.findEducacion((long)1);
    }
}
