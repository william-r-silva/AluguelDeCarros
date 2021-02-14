package com.faraorock.CarroDePrograma.Persistencia;

import com.faraorock.CarroDePrograma.Models.Filial;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Filial, Integer> {
    
	List<Filial> findByPlacaContaining(String Placa);
	List<Filial> findByMarcaContaining(String Marca);
	List<Filial> findByModeloContaining(String Modelo);
        List<Filial> findByCorContaining(String Cor);
}
