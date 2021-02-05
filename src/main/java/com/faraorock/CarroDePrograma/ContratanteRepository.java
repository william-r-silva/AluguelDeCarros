package com.faraorock.CarroDePrograma;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteRepository extends JpaRepository<Contratante, Integer> {
	List<Contratante> findBynomeContainingOrderBynome(String nome);
	List<Contratante> findfindBycnhContaining(int cnh);
}
