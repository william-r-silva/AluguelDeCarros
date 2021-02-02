package componentes.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import componentes.connection.ConexaoMySql;
import componentes.model.*;

public class CompartilharObjetivoDAO {

	private ConexaoMySql conexao;

	public CompartilharObjetivoDAO() {
		super();
		
		this.conexao = new ConexaoMySql();
	}

	public void addPerfil(CompartilhaObj obj) {
		this.conexao.abrirConexao();
		CompartilhaObj co= new CompartilhaObj();

		String sqlCadastra = "INSERT INTO compartilharObjetivo VALUES (null, ?, ?)";
		
		try {
			 
			PreparedStatement c = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlCadastra);
			 
			c.setLong(1, co.getPerfil().getIdPerfil());
			c.setLong(2, co.getObj().getId_Objetio());
			c.executeUpdate();
			c.close();
	
			 
		}catch (SQLException e) {
			e.printStackTrace();
	
			
		}finally {
			this.conexao.fecharConexao();
		}
	}
			

        public void excluirAdd(long id) {
			
			this.conexao.abrirConexao();
			
			String sqlDelete = "DELETE FROM compartilharObjetivo WHERE idCompartilha=?;";
			
			try {
				
				PreparedStatement statement = (PreparedStatement)this.conexao.getConexao().prepareStatement(sqlDelete);
				statement.setLong(1, id);
				statement.executeUpdate();
		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
			}
		
        public ArrayList<CompartilhaObj> buscarTodos(long id){
        	this.conexao.abrirConexao();
        	CompartilhaObj co=new CompartilhaObj();
        	ArrayList<CompartilhaObj> arroz=new ArrayList<CompartilhaObj>();
			
			String sqlDelete = "SELEC * FROM compartilharObjetivo co INNER JOIN objetivos o ON co.idPerfil = o.idPerfil INNER JOIN fotos f ON p.idFotos = f.idFotos INNER JOIN perfil p ON o.idPerfil = p.idPerfil INNER JOIN perfil pc ON pc.idPerfil = o.cPerfil INNER JOIN fotos fc ON pc.idFotos = fc.idFotos WHERE co.idPerfil=?;";
			
			try {
				
				PreparedStatement statement = (PreparedStatement)this.conexao.getConexao().prepareStatement(sqlDelete);
				statement.setLong(1, co.getPerfil().getIdPerfil());
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					co.getObj().getIdPerfil_objetivo().setIdPerfil(rs.getLong("p.idPerfil"));
					co.getObj().getIdPerfil_objetivo().setNomePerfil(rs.getString("p.nome"));
					co.getObj().getIdPerfil_objetivo().setApelidoPerfil(rs.getString("p.apelido"));
					co.getObj().getIdPerfil_objetivo().setConcluidosPerfil(rs.getInt("p.concluidos"));
					co.getObj().getIdPerfil_objetivo().getFotoPerfil().setUrl(rs.getString("f.url"));
					co.getObj().setId_Objetio(rs.getLong("o.idObjetivo"));
					co.getObj().setConcluido_objetivo(rs.getBoolean("o.concluido"));
					co.getObj().setTitulo_objetivo(rs.getString("o.titulo"));
					co.getObj().setTipo(rs.getInt("o.tipo"));
					co.getObj().setDescricao_objetivo(rs.getString("o.descricao_objetivo"));
					co.getObj().getCPerfil_objetivo().setNomePerfil(rs.getString("pc.nome"));
					co.getObj().getCPerfil_objetivo().setApelidoPerfil(rs.getString("pc.apelido"));
					co.getObj().getCPerfil_objetivo().setIdPerfil(rs.getInt("pc.idPerfil"));
					co.getObj().getCPerfil_objetivo().setConcluidosPerfil(rs.getInt("pc.concluidos"));
					co.getObj().getCPerfil_objetivo().getFotoPerfil().setUrl(rs.getString("fc.url"));
					arroz.add(co);
				}
		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
			return arroz;
        }		
		
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			




