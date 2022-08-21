package com.portfolio.egallar.Service;

import com.portfolio.egallar.Entity.Persona;
import com.portfolio.egallar.Interface.IPersonaService;
import com.portfolio.egallar.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    //Autowired permite inyectar dependencias dentro de otras con la mayor facilidad posible
    @Autowired
    IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> GetPersona() {
        List<Persona> listaPersona = iPersonaRepository.findAll();
        return listaPersona;
    }

    @Override
    public void savePersona(Persona per) {
        iPersonaRepository.save(per);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }

}
