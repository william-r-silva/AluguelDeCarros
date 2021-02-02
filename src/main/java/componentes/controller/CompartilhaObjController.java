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
		@RequestMapping("/comObj/") 
		public class CompartilhaObjController {
			
			private CompartilharObjetivoDAO comObj;
			
			@PostMapping
			public ResponseEntity<CompartilhaObj> cadastrar(@RequestBody CompartilhaObj obj) {
				comObj = new CompartilharObjetivoDAO();
				comObj.addPerfil(obj);
				return ResponseEntity.ok(obj);
			}

			@DeleteMapping("{id}")
			public ResponseEntity<Void> excluir(@PathVariable long id) {
				comObj = new CompartilharObjetivoDAO();
				comObj.excluirAdd(id);
				return ResponseEntity.noContent().build();
			}	
			
			@GetMapping("{id}")
			public ResponseEntity<ArrayList<CompartilhaObj>> buscarPorId(@PathVariable long id) {
				comObj = new CompartilharObjetivoDAO();
				ArrayList<CompartilhaObj> aobj = comObj.buscarTodos(id);
				if(aobj!=null) {
					return ResponseEntity.noContent().build();
				}		
				return ResponseEntity.notFound().build();
			}
			
			

}
