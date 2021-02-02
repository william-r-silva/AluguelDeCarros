	package componentes.persistencia;
	
	import componentes.connection.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import componentes.model.*;

	
	public class PerfilDAO {
		
		private ConexaoMySql conexao;
		
		public PerfilDAO () {
			super();
			this.conexao = new ConexaoMySql("localhost", "root", "", "bucketlist");
		}
		
	
	public Perfil cadastrarPerfil (Perfil perfil) {
		this.conexao.abrirConexao();
		
		String sqlCadastra="INSERT INTO perfil VALUES (null,?,?,?,0,?,null)";
		
		try {
			PreparedStatement Statement =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlCadastra);
			
			 Statement.setString(1, perfil.getNomePerfil());
			 Statement.setString(3, perfil.getEmailPerfil());
			 Statement.setString(2, perfil.getSenhaPerfil());
			 Statement.setString(4, perfil.getApelidoPerfil());
			 System.out.println(perfil.getApelidoPerfil());
			
			 Statement.executeUpdate();
			 Statement.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			this.conexao.fecharConexao();
		}
		return perfil;
		
	}
	
		
	public void editar(Perfil perfil) {
			
			this.conexao.abrirConexao();
			
			String sqlUpdate = "UPDATE perfil SET nome=?, email=?, senha=?, apelido=?, concluidos=?, foto=? WHERE idPerfil=?;";

			try {
				PreparedStatement Statement = (PreparedStatement)this.conexao.getConexao().prepareStatement(sqlUpdate);
				Statement.setString(1, perfil.getNomePerfil());
				 Statement.setString(2, perfil.getEmailPerfil());
				 Statement.setString(3, perfil.getSenhaPerfil());
				 Statement.setString(4, perfil.getApelidoPerfil());
				 Statement.setInt(5, perfil.getConcluidosPerfil());
				 Statement.setLong(6, perfil.getFotoPerfil().getIdFoto());
				 Statement.setLong(7, perfil.getIdPerfil());
				 Statement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
		}
      
	
	public Perfil buscarPorId(long id) {
		
		this.conexao.abrirConexao();
		
		String sqlInsert = "SELECT * FROM perfil WHERE idPerfil=?";
		PreparedStatement statement;
		Perfil perfil = null;
		
		try {
			statement =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
		
			while(rs.next()) {
				perfil = new Perfil();
				perfil.setIdPerfil(rs.getInt("idPerfil"));    
				perfil.setNomePerfil(rs.getString("nome"));
				perfil.setEmailPerfil(rs.getString("email"));
				perfil.setApelidoPerfil(rs.getString("Apelido"));
				perfil.setConcluidosPerfil(rs.getInt("Concluidos"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
		return perfil;
	  	}
	
	public void excluir(long id) {
		
		this.conexao.abrirConexao();
		
		String sqlDelete = "DELETE FROM perfil WHERE idPerfil=?;";
		
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

		
		public Perfil buscarPorApelido(String apelido) {
			this.conexao.abrirConexao();
			
			String sqlInsert = "SELECT * FROM perfil WHERE apelido=?;";
			PreparedStatement statement;
			Perfil perfil = null;
			
			try {
				statement =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert);
			     
				statement.setString(1, apelido);
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()) {
					perfil = new Perfil();
					perfil.setIdPerfil(rs.getInt("idPerfil"));    
					perfil.setNomePerfil(rs.getString("nome"));
					perfil.setEmailPerfil(rs.getString("email"));
					perfil.setApelidoPerfil(rs.getString("Apelido"));
					perfil.setConcluidosPerfil(rs.getInt("Concluidos"));
				}
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.conexao.fecharConexao();
			}
			return perfil;
		  	}



		public Perfil buscarPorEmailESenha(String email, String senha) {
				this.conexao.abrirConexao();
				
				String sqlInsert = "SELECT * FROM perfil WHERE email=? AND senha=?;";
				PreparedStatement statement;
				Perfil p = null;
				try {
				
					statement =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert);
				     
					statement.setString(1, email);
					statement.setString(2, senha);
					ResultSet rs = statement.executeQuery();
					
					if(rs.next()) {
						p = new Perfil();
						p.setIdPerfil(rs.getLong("perfil.idPerfil"));    
						p.setNomePerfil(rs.getString("nome"));
						p.setEmailPerfil(rs.getString("email"));
						p.setSenhaPerfil(rs.getString("senha"));
						p.setApelidoPerfil(rs.getString("apelido"));
						p.setConcluidosPerfil(rs.getInt("concluidos"));
					}
					
				
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					this.conexao.fecharConexao();
				}
				return p;
			  	}
		
		public ArrayList<Perfil> buscarTodos() {
			this.conexao.abrirConexao();
			
			String sqlInsert = "SELECT * FROM perfil;";
			PreparedStatement statement;
			Perfil p = null;
			ArrayList<Perfil> ap=new ArrayList<Perfil>();
			try {
			
				statement =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert); 
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					p = new Perfil();
					p.setIdPerfil(rs.getInt("idPerfil"));    
					p.setNomePerfil(rs.getString("nome"));
					p.setEmailPerfil(rs.getString("email"));
					p.setSenhaPerfil(rs.getString("senha"));
					p.setApelidoPerfil(rs.getString("apelido"));
					p.setConcluidosPerfil(rs.getInt("concluidos"));
					ap.add(p);
					
				}
				
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.conexao.fecharConexao();
			}
			return ap;
		  	}
		
		}
		
		
			
			
		
		
