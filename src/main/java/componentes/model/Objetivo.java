package componentes.model;

import java.util.ArrayList;

public class Objetivo {
	private long idObjetio;
	private String titulo;
	private boolean concluido;
	private String descricao;
	private Perfil cPerfil;
	private Perfil idPerfil;
	private int foto;
	private ArrayList<CompartilhaObj> comObj;
	private int tipo;
	
	public Objetivo(){
		super();
		this.idObjetio = 0;
		this.titulo = "";
		this.concluido = false;
		this.descricao = "";
		this.cPerfil = new Perfil();
		this.idPerfil = new Perfil();
		this.foto = 0;
		this.comObj = null;
	}
	
	public Objetivo(long idObjetio, String titulo, boolean concluido,
			String descricao, Perfil cPerfil, Perfil idPerfil, int foto,
			ArrayList<CompartilhaObj> comObj) {
		super();
		this.idObjetio = idObjetio;
		this.titulo = titulo;
		this.concluido = concluido;
		this.descricao = descricao;
		this.cPerfil = cPerfil;
		this.idPerfil = idPerfil;
		this.foto = foto;
		this.comObj = comObj;
	}
	
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public long getId_Objetio() {
		return idObjetio;
	}
	public void setId_Objetio(long idObjetio) {
		this.idObjetio = idObjetio;
	}
	public String getTitulo_objetivo() {
		return titulo;
	}
	public void setTitulo_objetivo(String titulo) {
		this.titulo = titulo;
	}
	public boolean isConcluido_objetivo() {
		return concluido;
	}
	public void setConcluido_objetivo(boolean concluido) {
		this.concluido = concluido;
	}
	public String getDescricao_objetivo() {
		return descricao;
	}
	public void setDescricao_objetivo(String descricao) {
		this.descricao = descricao;
	}
	public Perfil getCPerfil_objetivo() {
		return cPerfil;
	}
	public void setCPerfil_objetivo(Perfil cPerfil) {
		this.cPerfil = cPerfil;
	}
	public Perfil getIdPerfil_objetivo() {
		return idPerfil;
	}
	public void setIdPerfil_objetivo(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}
	public int getFoto_objetivo() {
		return foto;
	}
	public void setFoto_objetivo(int foto) {
		this.foto = foto;
	}
	public ArrayList<CompartilhaObj> getComObj() {
		return comObj;
	}
	public void setComObj(ArrayList<CompartilhaObj> comObj) {
		this.comObj = comObj;
	}

}
