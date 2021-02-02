package componentes.controller;

import java.util.ArrayList;
import java.util.List;

import componentes.model.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import componentes.persistencia.*;

		@RestController
		@RequestMapping("/objetivo/") 
		public class ObjetivoController {
			
			private ObjetivoDAO oDAO;
			
			@PostMapping
			public ResponseEntity<Objetivo> cadastrar(@RequestBody Objetivo obj) {
				oDAO = new ObjetivoDAO();
				oDAO.cadastrar(obj);
				return ResponseEntity.ok(obj);
			}
			
			@PutMapping
			public ResponseEntity<Void> editar(@RequestBody Objetivo obj) {
				oDAO = new ObjetivoDAO();
				oDAO.editar(obj);
				return ResponseEntity.noContent().build();
			}

			@DeleteMapping("{id}")
			public ResponseEntity<Void> excluir(@PathVariable long id) {
				oDAO = new ObjetivoDAO();
				oDAO.excluir(id);
				return ResponseEntity.noContent().build();
			}	
			
			@GetMapping("{id}/{idPerfil}")
			public ResponseEntity<ArrayList<Objetivo>> buscarPorId(@PathVariable long id ) {
				oDAO = new ObjetivoDAO();
				ArrayList<Objetivo> aobj = oDAO.buscarTodosPorPerfil(id);
				if(aobj!=null) {
					return ResponseEntity.noContent().build();
				}		
				return ResponseEntity.notFound().build();
			}			
			

}
