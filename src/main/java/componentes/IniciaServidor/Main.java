package componentes.IniciaServidor;

import componentes.persistencia.FotoDAO;
import componentes.persistencia.PerfilDAO;
import componentes.model.*;

public class Main {
	public static void main(String [] args) {
		Foto foto=new Foto(0, null, null, null,
				null);
		FotoDAO fDAO = new FotoDAO();
		foto.setIdFoto(fDAO.cadastrar(foto));
		System.out.println(foto.getIdFoto());
	}
}
