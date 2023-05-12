package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Dto.dtoExperiencia;
import com.lvportfolio.argpro.Dto.dtoHabilidad;
import com.lvportfolio.argpro.Entity.Experiencia;
import com.lvportfolio.argpro.Entity.Habilidad;
import com.lvportfolio.argpro.Security.Controller.Mensaje;
import com.lvportfolio.argpro.Service.ImpExperienciaService;
import com.lvportfolio.argpro.Service.ImpHabilidadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("habilidades")
@CrossOrigin(origins = "http://localhost:4200")
public class HabilidadController {
    @Autowired
    ImpHabilidadService impHabilidadService;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list(){
        List<Habilidad> list = impHabilidadService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable("id") int id){
        if(!impHabilidadService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = impHabilidadService.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidad dtohab){
        if(dtohab == null)
            return new ResponseEntity(new Mensaje("El objeto dtoHabilidad es nulo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtohab.getHabilidad()))
            return new ResponseEntity(new Mensaje("La habilidad es obligatoria"), HttpStatus.BAD_REQUEST);
        if(impHabilidadService.existsByHabilidad(dtohab.getHabilidad()))
            return new ResponseEntity(new Mensaje("Esa habilidad existe"), HttpStatus.BAD_REQUEST);

        Habilidad habilidad = new Habilidad(dtohab.getHabilidad(), dtohab.getPorcentaje());
        impHabilidadService.save(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHabilidad dtohab){
        //Validamos si existe el id
        if(!impHabilidadService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);}

        if(impHabilidadService.existsByHabilidad(dtohab.getHabilidad()) && impHabilidadService.getByHabilidad(dtohab.getHabilidad()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);}
        //No puede estar vacío
        if(StringUtils.isBlank(dtohab.getHabilidad())){
            return new ResponseEntity(new Mensaje("La habilidad es obligatoria"), HttpStatus.BAD_REQUEST);}

        Habilidad habilidad = impHabilidadService.getOne(id).get();
        habilidad.setHabilidad(dtohab.getHabilidad());
        habilidad.setPorcentaje((dtohab.getPorcentaje()));

        impHabilidadService.save(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impHabilidadService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impHabilidadService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
