package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;

public class CadastroDAO {

	private Connection conexao;

	public CadastroDAO() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserirLogin(String nomeFuncionario,  String funcao, String usuario, String senha, String setor) {
		try {
			Statement executorComandos = conexao.createStatement();
			executorComandos
					.executeUpdate("insert into funcionario(nome_funcionario, funcao, usuario , senha ,setor) values ('"
							+ nomeFuncionario +  "','" + funcao + "','" + usuario + "','" + senha + "','" 
							+ setor +"');");
							

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public boolean compararLogin(String usuario) {
		try {
			Statement executorValidar = conexao.createStatement();
			ResultSet resultadoSelect = executorValidar
					.executeQuery("select usuario from funcionario where usuario= '" + usuario + "';");

			if (resultadoSelect.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
