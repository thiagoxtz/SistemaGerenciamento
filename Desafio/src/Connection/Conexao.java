package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private Connection conexao;
	
	public Conexao(){
		
		try{
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SistemaChamados", "postgres","adm");
			//usu�rio e senha
		}
		catch(Exception a){
			System.out.print("Erro de Conex�o" + a);
		}
	}
	public Connection getConexao(){
		return this.conexao;
	}
}
