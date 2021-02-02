package componentes.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import componentes.model.Adiciona;
import componentes.model.CompartilhaObj;
import componentes.model.Conquistas;
import componentes.model.Foto;
import componentes.model.Objetivo;
import componentes.model.Perfil;
import componentes.persistencia.PerfilDAO;

@RestController
@RequestMapping("/perfil/")
public class PerfilController {
	
	static int cont=0;
	private PerfilDAO pDAO;

	@PostMapping("{perfil}")
	public ResponseEntity<Perfil> cadastrar(@RequestBody String nome, String email, String senha, String apelido) {
		pDAO = new PerfilDAO();
		Perfil perfil = new Perfil(0, nome, senha, email,0, apelido, null, null, null, null, null);
		perfil = pDAO.cadastrarPerfil(perfil);
		return ResponseEntity.ok(perfil);
	}

	@PutMapping
	public ResponseEntity<Void> editar(@RequestBody Perfil perfil) {
		pDAO = new PerfilDAO();
		pDAO.editar(perfil);
		return ResponseEntity.noContent().build();
	}

	 @DeleteMapping("{id}")
	 public ResponseEntity<Void> excluir(@PathVariable long id) {
	 pDAO = new PerfilDAO();
	 pDAO.excluir(id);
	 return ResponseEntity.noContent().build();
	 }

	@GetMapping
	public ResponseEntity<ArrayList<Perfil>> buscarTodos() {
		pDAO = new PerfilDAO();
		ArrayList<Perfil> per = pDAO.buscarTodos();
		return new ResponseEntity<ArrayList<Perfil>>(per, HttpStatus.FOUND);
	}

	@GetMapping("eu+{id}")
	public ResponseEntity<Perfil> buscarPorId(@PathVariable long id) {
		pDAO = new PerfilDAO();
		Perfil perfil = pDAO.buscarPorId(id);
		if (perfil != null) {
			return new ResponseEntity<Perfil>(perfil, HttpStatus.FOUND);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("ape+{apelido}")
	public ResponseEntity<Perfil> buscarPorApelido(@PathVariable String apelido) {
		pDAO = new PerfilDAO();
		Perfil perfil = pDAO.buscarPorApelido(apelido);
		if (perfil != null) {
			return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("log+{email}/{senha}")
	public ResponseEntity<Perfil> buscarPorLoginESenha(
			@PathVariable String email, @PathVariable String senha) {
		pDAO = new PerfilDAO();
		Perfil perfil = pDAO.buscarPorEmailESenha(email, senha);
		if (perfil != null) {
			System.out.println("Acessando "+cont);
			cont++;
			return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
		}
		return new ResponseEntity<Perfil>(HttpStatus.NOT_FOUND);
	}
}
