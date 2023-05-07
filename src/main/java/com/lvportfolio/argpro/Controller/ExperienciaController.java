package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Entity.Experiencia;
import com.lvportfolio.argpro.Security.Controller.Mensaje;
import com.lvportfolio.argpro.Service.ImpExperienciaService;
import com.lvportfolio.argpro.Dto.dtoExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ImpExperienciaService impExperienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getPuesto())){
            return new ResponseEntity(new Mensaje("EL nombre es obligatorio"), HttpStatus.BAD_REQUEST);}
        if(impExperienciaService.existsByPuesto(dtoexp.getPuesto())){
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);}
        Experiencia experiencia = new Experiencia(dtoexp.getPuesto(), dtoexp.getLugar());
        impExperienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //Validamos si existe el id
        if(!impExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);}

        if(impExperienciaService.existsByPuesto(dtoexp.getPuesto()) && impExperienciaService.getByPuesto(dtoexp.getPuesto()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);}
        //No puede estar vacío
        if(StringUtils.isBlank(dtoexp.getPuesto())){
            return new ResponseEntity(new Mensaje("El puesto es obligatorio"), HttpStatus.BAD_REQUEST);}

        Experiencia experiencia = impExperienciaService.getOne(id).get();
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setLugar((dtoexp.getLugar()));

        impExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impExperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
