package componentes.model;

import java.util.ArrayList;

public class Trofeu {
	private long idTrofeu;
	private String nome;
	private Foto foto;
	private String descricao;
	private ArrayList<Conquistas> conquista;
	
	public long getIdTrofeu() {
		return idTrofeu;
	}
	public void setIdTrofeu(long idTrofeu) {
		this.idTrofeu = idTrofeu;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Foto getFoto() {
		return foto;
	}
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<Conquistas> getConquista() {
		return conquista;
	}
	public void setConquista(ArrayList<Conquistas> conquista) {
		this.conquista = conquista;
	}
}
