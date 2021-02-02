package componentes.connection;

import java.beans.Statement;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.PingTarget;
import com.mysql.jdbc.ResultSetInternalMethods;

public class ConexaoMySql{

	private String ip;
	private String login;
	private String senha;
	private String nomeBD;
	private Connection conexao;

	
	public ConexaoMySql() {
		super();
	}

	public ConexaoMySql(String ip, String login, String senha, String nomeBD) {
		super();
		this.ip = ip;
		this.login = login;
		this.senha = senha;
		this.nomeBD = nomeBD;
	}

	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeBD() {
		return nomeBD;
	}

	public void setNomeBD(String nomeBD) {
		this.nomeBD = nomeBD;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public void abrirConexao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String endereco = "jdbc:mysql://"+this.ip+":3306/"+this.nomeBD;
			this.conexao = (Connection) DriverManager.getConnection(endereco, this.login, this.senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fecharConexao() {
		try {
			if(!this.conexao.isClosed()) {
				this.conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
