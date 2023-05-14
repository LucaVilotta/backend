package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Entity.Proyecto;
import com.lvportfolio.argpro.Interface.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://portfolio-frontend-luca.web.app")
public class ProyectoController {
    @Autowired
    IProyectoService iproyectoService;

    @GetMapping("proyecto/traer")
    public List<Proyecto> getProyecto(){return iproyectoService.getProyecto();}

    @PostMapping("/proyecto/crear")
    public String createProyecto(@RequestBody Proyecto proyecto){
        iproyectoService.saveProyecto(proyecto);
        return "El proyecto fué creado correctamente";
    }

    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        iproyectoService.deleteProyecto(id);
        return "El proyecto fué eliminado correctamente";
    }

    //URL: PUERTO/proyecto/editar/id/
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto editProyecto(@PathVariable Long id,
                                   @RequestBody Proyecto proyecto){
        Proyecto oldProyecto = iproyectoService.findProyecto(id);


        oldProyecto.setTitulo(proyecto.getTitulo());
        oldProyecto.setEnlace(proyecto.getEnlace());
        oldProyecto.setImg(proyecto.getImg());
        oldProyecto.setDescripcion(proyecto.getDescripcion());
        iproyectoService.saveProyecto(oldProyecto);
        return oldProyecto;
    }
}
