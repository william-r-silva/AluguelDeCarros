package componentes.model;

public class Conquistas {
	private long idConquista;
	private Trofeu trofeu;
	private Perfil perfil;
	
	public long getIdConquista() {
		return idConquista;
	}
	public void setIdConquista(long idConquista) {
		this.idConquista = idConquista;
	}
	public Trofeu getTrofeu() {
		return trofeu;
	}
	public void setTrofeu(Trofeu trofeu) {
		this.trofeu = trofeu;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
