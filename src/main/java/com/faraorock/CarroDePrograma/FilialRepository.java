package com.faraorock.CarroDePrograma;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialRepository extends JpaRepository<Filial, Integer> {
	List<Filial> findBycepContaining(int cep);
	List<Filial> findBycidadeContaining(String cidade);
	List<Filial> findByestadoContaining(String estado);
}
