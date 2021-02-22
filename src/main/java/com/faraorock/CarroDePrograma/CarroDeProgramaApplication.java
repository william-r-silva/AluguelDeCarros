package com.faraorock.CarroDePrograma;

import com.faraorock.CarroDePrograma.Persistencia.FilialRepository;
import com.faraorock.CarroDePrograma.Persistencia.MecanicaParceiraRepository;
import com.faraorock.CarroDePrograma.Persistencia.CarroRepository;
import com.faraorock.CarroDePrograma.Persistencia.ContratanteRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import com.faraorock.CarroDePrograma.View.MainView;

@SpringBootApplication
public class CarroDeProgramaApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(CarroDeProgramaApplication.class);
        builder.headless(false);
        builder.run(args);
	}
	
	@Bean
	public ContratanteRepository run(ContratanteRepository cr) {
		
		return cr;
	}
	
	@Bean
	public FilialRepository run2(FilialRepository fr) {
		MainView.criaUI();
		return fr;
	}

	@Bean
	public CarroRepository run3(CarroRepository car) {
		
		return car;
	}
	
	@Bean
	public MecanicaParceiraRepository run4(MecanicaParceiraRepository mpr) {
		
		return mpr;
	}
}
