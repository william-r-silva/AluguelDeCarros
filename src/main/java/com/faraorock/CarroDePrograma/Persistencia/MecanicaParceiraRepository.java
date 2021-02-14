package com.faraorock.CarroDePrograma.Persistencia;

import com.faraorock.CarroDePrograma.Models.MecanicaParceira;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicaParceiraRepository extends JpaRepository<MecanicaParceira, Integer> {
    
	List<MecanicaParceira> findByNomeContainingOrderByNome(String nome);
	List<MecanicaParceira> findByEstadoContainingOrCidadeContainingOrRuaContainingByNome(String Estado, String Cidade, String Rua);
}
