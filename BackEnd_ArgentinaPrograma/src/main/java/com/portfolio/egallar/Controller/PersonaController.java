package com.portfolio.egallar.Controller;

import com.portfolio.egallar.Entity.Persona;
import com.portfolio.egallar.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("/personas/traer") //ruta por la que trae la información del FrontEnd
    public List<Persona> getPersona() {
        return iPersonaService.GetPersona();
    }

    @PostMapping("/personas/crear") //desde el FrontEnd, para guardar en la base de datos
    public String createPersona(@RequestBody Persona per) {

        iPersonaService.savePersona(per);
        return "La persona fue creada correctamente.";
    }

    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg) {

        Persona per = iPersonaService.findPersona(id);

        per.setNombre(nuevoNombre);
        per.setApellido(nuevoApellido);
        per.setImg(nuevoImg);

        iPersonaService.savePersona(per);
        return per;
    }

    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return iPersonaService.findPersona((long) 1);
    }
}
