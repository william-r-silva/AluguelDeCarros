package componentes.model;

public class Adiciona {
	private long idAmizade;
	private Perfil amigo;
	private Perfil perfil;
	
	
	public Adiciona(long idAmizade, Perfil amigo, Perfil perfil) {
		super();
		this.idAmizade = idAmizade;
		this.amigo = amigo;
		this.perfil = perfil;
	}
	public long getIdAmizade() {
		return idAmizade;
	}
	public void setIdAmizade(long idAmizade) {
		this.idAmizade = idAmizade;
	}
	public Perfil getAmigo() {
		return amigo;
	}
	public void setAmigo(Perfil amigo) {
		this.amigo = amigo;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}
