package com.faraorock.CarroDePrograma.Persistencia;

import com.faraorock.CarroDePrograma.Models.Contratante;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteRepository extends JpaRepository<Contratante, Integer> {
	List<Contratante> findByNomeContainingOrderByNome(String nome);
	List<Contratante> findByCnhContaining(int cnh);
}
