package componentes.model;

public class CompartilhaObj {
	private long idCompart;
	private Perfil perfil;
	private Objetivo obj;
	
	public long getIdCompart() {
		return idCompart;
	}
	public void setIdCompart(long idCompart) {
		this.idCompart = idCompart;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Objetivo getObj() {
		return obj;
	}
	public void setObj(Objetivo obj) {
		this.obj = obj;
	}
	
}
