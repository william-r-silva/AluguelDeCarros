package componentes.model;

import java.util.*;

public class Perfil {
	private long idPerfil;
	private String nome;
	private String senha;
	private String email;
	private int concluidos;
	private String apelido;
	private Foto foto;
	private ArrayList<Objetivo> obj;
	private ArrayList<Adiciona> amigos;
	private ArrayList<Conquistas> trofeus;
	private ArrayList<CompartilhaObj> compartilhados;
	
	
	public Perfil() {
		super();
		this.idPerfil = 0;
		this.nome = "";
		this.senha = "";
		this.email = "";
		this.concluidos = 0;
		this.apelido = "";
		this.foto = new Foto();
		this.obj = null;
		this.amigos = null;
		this.trofeus = null;
		this.compartilhados = null;
	}
	
	public Perfil(long idPerfil, String nome, String senha, String email,
			int concluidos, String apelido, Foto foto, ArrayList<Objetivo> obj,
			ArrayList<Adiciona> amigos, ArrayList<Conquistas> trofeus,
			ArrayList<CompartilhaObj> compartilhados) {
		super();
		this.idPerfil = idPerfil;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.concluidos = concluidos;
		this.apelido = apelido;
		this.foto = foto;
		this.obj = obj;
		this.amigos = amigos;
		this.trofeus = trofeus;
		this.compartilhados = compartilhados;
	}

	public long getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNomePerfil() {
		return nome;
	}
	public void setNomePerfil(String nome) {
		this.nome = nome;
	}
	public String getSenhaPerfil() {
		return senha;
	}
	public void setSenhaPerfil(String senha) {
		this.senha = senha;
	}
	public String getEmailPerfil() {
		return email;
	}
	public void setEmailPerfil(String email) {
		this.email = email;
	}
	public int getConcluidosPerfil() {
		return concluidos;
	}
	public void setConcluidosPerfil(int concluidos) {
		this.concluidos = concluidos;
	}
	public String getApelidoPerfil() {
		return apelido;
	}
	public void setApelidoPerfil(String apelido) {
		this.apelido = apelido;
	}
	public Foto getFotoPerfil() {
		return foto;
	}
	public void setFotoPerfil(Foto foto) {
		this.foto = foto;
	}
	public ArrayList<Objetivo> getObj() {
		return obj;
	}
	public void setObj(ArrayList<Objetivo> obj) {
		this.obj = obj;
	}
	public ArrayList<Adiciona> getAmigosPerfil() {
		return amigos;
	}
	public void setAmigosPerfil(ArrayList<Adiciona> amigos) {
		this.amigos = amigos;
	}
	public ArrayList<Conquistas> getTrofeusPerfil() {
		return trofeus;
	}
	public void setTrofeusPerfil(ArrayList<Conquistas> trofeus) {
		this.trofeus = trofeus;
	}
	public ArrayList<CompartilhaObj> getCompartilhadosPerfil() {
		return compartilhados;
	}
	public void setCompartilhadosPerfil(ArrayList<CompartilhaObj> compartilhados) {
		this.compartilhados = compartilhados;
	}
}
