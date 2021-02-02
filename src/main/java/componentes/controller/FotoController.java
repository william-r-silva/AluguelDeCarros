package componentes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import componentes.model.Foto;
import componentes.model.Objetivo;
import componentes.persistencia.FotoDAO;
import componentes.persistencia.ObjetivoDAO;

@RestController
@RequestMapping("/foto/")
public class FotoController {
	
	FotoDAO fDAO;
	
	@PostMapping
	public ResponseEntity<Foto> cadastrar(@RequestBody Foto foto) {
		fDAO = new FotoDAO();
		fDAO.cadastrar(foto);
		return ResponseEntity.ok(foto);
	}
	
	@PutMapping
	public ResponseEntity<Foto> editar(@RequestBody Foto foto){
		fDAO = new FotoDAO();
		foto = fDAO.editar(foto);
		return ResponseEntity.ok(foto);
	}

}
