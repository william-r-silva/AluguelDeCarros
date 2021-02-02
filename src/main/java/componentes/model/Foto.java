package componentes.model;

public class Foto {
	private long idFoto;
	private String url;
	private Perfil perfil;
	private Trofeu trofeu;
	private Objetivo obj;
	
	public Foto(){
		super();
		this.idFoto = 1;
		this.url = null;
		this.perfil = null;
		this.trofeu = null;;
		this.obj = null;
	}
	
	
	public Foto(long idFoto, String url, Perfil perfil, Trofeu trofeu,
			Objetivo obj) {
		super();
		this.idFoto = idFoto;
		this.url = url;
		this.perfil = perfil;
		this.trofeu = trofeu;
		this.obj = obj;
	}


	public long getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Trofeu getTrofeu() {
		return trofeu;
	}
	public void setTrofeu(Trofeu trofeu) {
		this.trofeu = trofeu;
	}
	public Objetivo getObj() {
		return obj;
	}
	public void setObj(Objetivo obj) {
		this.obj = obj;
	}
	
}
