package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Conexao;

public class LoginDAO {

	private Connection conexao;

	public LoginDAO() {
		Conexao connection = new Conexao();

		this.conexao = connection.getConexao();
	}

	public boolean Logar(String usuario, String senha) {

		try {
			Statement executorComandos = conexao.createStatement();
			ResultSet resultadoSelect = executorComandos
					.executeQuery("select usuario, senha from funcionario where usuario = '" + usuario
							+ "' AND  senha ='" + senha + "';");
			if (resultadoSelect.next()) {
				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
