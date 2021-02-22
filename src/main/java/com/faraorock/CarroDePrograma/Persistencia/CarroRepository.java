package com.faraorock.CarroDePrograma.Persistencia;

import com.faraorock.CarroDePrograma.Models.Carro;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Integer> {
    
	List<Carro> findByPlacaContaining(String Placa);
	List<Carro> findByMarcaContaining(String Marca);
	List<Carro> findByModeloContaining(String Modelo);
    List<Carro> findByCorContaining(String Cor);
}
