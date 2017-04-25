package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.Conexao;
import Model.Setor;

public class FuncionariosNoSetorDAO {

	private Connection conexao;

	public FuncionariosNoSetorDAO() {
		this.conexao = new Conexao().getConexao();
	}

	public void addFuncionarioNoSetor(String id_setor, String id_funcionario) {
		try {

			Statement executorComandos = conexao.createStatement();
			executorComandos.executeUpdate("insert into setores(nome_setor, id_funcionario) values ('" + id_setor
					+ "','" + id_funcionario + "');");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Setor> selectSetores() {
		ArrayList<Setor> setores = new ArrayList<Setor>();
		try {
			Statement executarCapturaSetores = conexao.createStatement();
			ResultSet resultado = executarCapturaSetores.executeQuery("select * from setores");

			while (resultado.next()) {
				Setor setor = new Setor(resultado.getString("nome_setor"), resultado.getInt("id_setor"));
				setores.add(setor);

			}
			return setores;
		} catch (Exception e) {
			// TODO: handle exception
			return setores;
		}
	}

}
