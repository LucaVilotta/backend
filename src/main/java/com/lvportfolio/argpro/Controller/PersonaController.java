package com.lvportfolio.argpro.Controller;

import com.lvportfolio.argpro.Entity.Persona;
import com.lvportfolio.argpro.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fué creada correctamente";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fué eliminada correctamente";
    }

    //URL: PUERTO/personas/editar/id/nombre & apellido & img
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestBody Persona persona){
        Persona oldPersona = ipersonaService.findPersona(id);


        oldPersona.setNombre(persona.getNombre());
        oldPersona.setApellido(persona.getApellido());
        oldPersona.setImg(persona.getImg());
        oldPersona.setSobreMi(persona.getSobreMi());
        oldPersona.setEspecializacion(persona.getEspecializacion());

        ipersonaService.savePersona(oldPersona);
        return oldPersona;
    }

    @GetMapping("/personas/traer/perfil") /*Esto no se pq está acá xd*/
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }

}
