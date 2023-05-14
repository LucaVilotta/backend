package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Dto.dtoEducacion;
import com.lvportfolio.argpro.Entity.Educacion;
import com.lvportfolio.argpro.Interface.IEducacionService;
import com.lvportfolio.argpro.Security.Controller.Mensaje;
import com.lvportfolio.argpro.Service.ImpEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = "https://portfolio-frontend-luca.web.app")
public class EducacionController {
    @Autowired ImpEducacionService impEducacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){
        if(dtoedu == null)
            return new ResponseEntity(new Mensaje("El objeto dtoEducacion es nulo"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("La educacion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(impEducacionService.existsByInstitucion(dtoedu.getInstitucion()))
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);

        Educacion educacion = new Educacion(dtoedu.getInstitucion(), dtoedu.getTitulo());
        impEducacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
        //Validamos si existe el id
        if(!impEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);}

        if(impEducacionService.existsByInstitucion(dtoedu.getInstitucion()) && impEducacionService.getByInstitucion(dtoedu.getInstitucion()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);}
        //No puede estar vacío
        if(StringUtils.isBlank(dtoedu.getInstitucion())){
            return new ResponseEntity(new Mensaje("La institucion es obligatoria"), HttpStatus.BAD_REQUEST);}

        Educacion educacion = impEducacionService.getOne(id).get();
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setTitulo((dtoedu.getTitulo()));

        impEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
}
