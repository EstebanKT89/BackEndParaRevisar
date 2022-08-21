package com.portfolio.egallar.Repository;

import com.portfolio.egallar.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository <Persona, Long> {
    
    
    
}
