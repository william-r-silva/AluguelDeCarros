package com.faraorock.CarroDePrograma.Persistencia;

import com.faraorock.CarroDePrograma.Models.Filial;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialRepository extends JpaRepository<Filial, Integer> {
    
	List<Filial> findByCepContaining(int cep);
	List<Filial> findByCidadeContaining(String cidade);
	List<Filial> findByEstadoContaining(String estado);
        
}
