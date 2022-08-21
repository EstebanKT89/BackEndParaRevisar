package com.portfolio.egallar.Interface;

import com.portfolio.egallar.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //Traer una lista de personas
    public List <Persona> GetPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona (Persona per);
    
    //Eliminar un objeto por ID
    public void deletePersona (Long id);
    
    //Buscar una Persona por ID
    public Persona findPersona (Long id);
}
