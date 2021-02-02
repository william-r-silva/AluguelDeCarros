package componentes.persistencia;
	
	import componentes.connection.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import com.sun.javafx.animation.TickCalculation;

import componentes.model.*;
	
public class ObjetivoDAO {

	private ConexaoMySql conexao;
	

	public ObjetivoDAO() {
		super();
		this.conexao = new ConexaoMySql("localhost", "root", "", "bucketlist");
	}
	
	
	public void cadastrar(Objetivo obj) {
		this.conexao.abrirConexao();
		
		String sqlCadastra="INSERT INTO objetivos VALUES (null,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement x = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlCadastra);
			x.setString(1, obj.getTitulo_objetivo());
			x.setBoolean(2, obj.isConcluido_objetivo());
			x.setString(3, obj.getDescricao_objetivo());
			x.setLong(4, obj.getCPerfil_objetivo().getIdPerfil());
			x.setLong(6, obj.getIdPerfil_objetivo().getIdPerfil());
			x.setInt(5, obj.getFoto_objetivo());
			x.setInt(7, obj.getTipo());
			x.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			this.conexao.fecharConexao();
		}
		
	}
		
	public ArrayList<Objetivo> buscarTodosPorPerfil(long idp) {
		
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM objetivos o INNER JOIN perfil p ON o.cPerfil=p.idPerfil INNER JOIN perfil pe ON o.idPerfil=pe.idPerfil WHERE o.idPerfil=?";
		
		PreparedStatement c;
		Objetivo obj1 = null;
		Perfil p;
		ArrayList<Objetivo> listaObj = new ArrayList<Objetivo>();
		
		try{
			c=(PreparedStatement)this.conexao.getConexao().prepareStatement(sqlInsert);
			c.setLong(1, idp);
			ResultSet rs = c.executeQuery();
			
			
			while(rs.next()){
				obj1 = new Objetivo();
				p = new Perfil();
				
				obj1.setId_Objetio(rs.getInt("o.idObjetivo"));
				obj1.setTitulo_objetivo(rs.getString("o.titulo"));
				obj1.setConcluido_objetivo(rs.getBoolean("o.conlcuido"));
				obj1.setDescricao_objetivo(rs.getString("o.descricao_objetivo"));
				
				if(rs.getString("o.cPerfil")!= null){
					p.setIdPerfil(rs.getLong("p.idPerfil"));
					p.setApelidoPerfil(rs.getString("p.apelido"));
					p.setNomePerfil(rs.getString("p.nome"));
					obj1.setCPerfil_objetivo(p);
				}
				p.setIdPerfil(rs.getLong("pe.idPerfil"));
				p.setApelidoPerfil(rs.getString("pe.apelido"));
				p.setNomePerfil(rs.getString("pe.nome"));
				obj1.setIdPerfil_objetivo(p);
				
				listaObj.add(obj1);
				
				
			}
		}catch (SQLException e){
				e.printStackTrace();
			}finally {
				this.conexao.fecharConexao();
				}
			return listaObj;
		}
			
		
	public void editar (Objetivo obj){
		this.conexao.abrirConexao();
		
		
		String sqlUpdate = "UPDATE objetivos SET titulo=?, concluido=?, descricao_objetivo=?, cPerfil=?, idFotos=? WHERE idObjetivo=?;";
		
		try{
			
			PreparedStatement o = (PreparedStatement)this.conexao.getConexao().prepareStatement(sqlUpdate);
			 
			o.setString(1, obj.getTitulo_objetivo());
			o.setBoolean(2, obj.isConcluido_objetivo());
			o.setString(3, obj.getDescricao_objetivo());
			o.setLong(4, obj.getCPerfil_objetivo().getIdPerfil());
			o.setLong(5, obj.getFoto_objetivo());
			o.execute();
			
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();		
	}	

	}

		public void excluir (long id_objetivo) {
			
			
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM objetivos WHRERE idObjetivo=?";
		
		try {
			
			PreparedStatement x = (PreparedStatement)this.conexao.getConexao().prepareStatement(sqlDelete);
			x.setLong(1, id_objetivo);
			x.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			this.conexao.fecharConexao();
		}
		
		}
	
}

	
