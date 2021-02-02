package componentes.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import componentes.connection.ConexaoMySql;
import componentes.model.Foto;
import componentes.model.Objetivo;

public class FotoDAO {
	
	ConexaoMySql conexao;
	
	public long cadastrar(Foto foto) {
		this.conexao.abrirConexao();
		
		String sqlCadastra="INSERT INTO fotos VALUES (null, ?)";
		
		try {
			PreparedStatement x = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlCadastra, Statement.RETURN_GENERATED_KEYS);
			x.setString(1, foto.getUrl());
			x.executeUpdate();
			
			try(ResultSet getKey= x.getGeneratedKeys()){
				if(getKey.next()){
					return getKey.getLong(1);
				}else{
					return -1;
				}
			}catch(SQLException e){
				e.printStackTrace();
				return -1;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
		return -1;
	}
	public Foto editar (Foto foto){
		this.conexao.abrirConexao();
		
		
		String sqlUpdate = "UPDATE fotos SET url=? WHERE idFotos=?;";
		
		try{
			
			PreparedStatement o = (PreparedStatement)this.conexao.getConexao().prepareStatement(sqlUpdate);
			 
			o.setString(1, foto.getUrl());
			o.setLong(2, foto.getIdFoto());
			o.execute();
			
			try(ResultSet getKey= o.getGeneratedKeys()){
				if(getKey.next()){
					foto.setIdFoto(getKey.getLong(1));
					return foto;
				}else{
					return null;
				}
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();		
	}	
		return null;
	}
	
}
