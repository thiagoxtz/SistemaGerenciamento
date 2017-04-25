package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connection.Conexao;
import Model.Chamado;

public class ChamadoDAO {

	private Connection conexao;

	public ChamadoDAO() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserirChamadosBD(String cliente, String descChamado, String notificacao, String tipoIncidente,
			String resolucao, String status) {
		try {
			Statement executarInserirChamado = conexao.createStatement();
			executarInserirChamado.executeUpdate(
					"insert into chamado(nome_cliente, descricao, notificacao, tipo_incidente, resolucao, status) values ('"
							+ cliente + "','" + descChamado + "','" + notificacao + "','" + tipoIncidente + "','"
							+ resolucao + "','" + status + "');");
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public Chamado updateOneChamado(String nome_cliente, String descricao, String notificacao, 
			String tipoIncidente, String status, String resolucao, int idChamado) {
		try {
			Statement executarCapturaSetores = conexao.createStatement();
			executarCapturaSetores.executeUpdate("update chamado set nome_cliente = '"
					+ nome_cliente + "', descricao = '" + descricao + "', notificacao = '" + notificacao
					+ "', tipo_incidente = '" + tipoIncidente + "', status ='" + status + "', resolucao = '" + resolucao
					+ "' where id_numero_chamado = '" + idChamado + "';");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Chamado getOneChamado(int idNumeroChamado) {
		try {
			Statement executarCapturaSetores = conexao.createStatement();
			@SuppressWarnings("unused")
			ResultSet resultado = executarCapturaSetores
					.executeQuery("select * from chamado where id_numero_chamado = " + idNumeroChamado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Chamado> getAllChamados() {
		ArrayList<Chamado> chamados = new ArrayList<Chamado>();
		try {
			Statement executarCapturaSetores = conexao.createStatement();
			ResultSet resultado = executarCapturaSetores
					.executeQuery("select * from chamado where status = '-Pendente-'");
			while (resultado.next()) {
				Chamado chamado = new Chamado(resultado.getInt("id_numero_chamado"),
						resultado.getString("nome_cliente"), resultado.getString("descricao"),
						resultado.getString("notificacao"), resultado.getString("tipo_incidente"),
						resultado.getInt("id_funcionario"), resultado.getString("status"),
						resultado.getString("resolucao"));
				chamados.add(chamado);
			}
			return chamados;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Chamado> getChamadosByID(int id) {
		ArrayList<Chamado> chamados = new ArrayList<Chamado>();
		try {
			Statement executarCapturaSetores = conexao.createStatement();
			// Traz os valores do banco de dados
			ResultSet resultado = executarCapturaSetores.executeQuery("select * from chamado where id = " + id);
			// Faz um for para preencher o objeto
			while (resultado.next()) {
				Chamado chamado = new Chamado(resultado.getInt("id_numero_chamado"),
						resultado.getString("nome_cliente"), resultado.getString("descricao"),
						resultado.getString("notificacao"), resultado.getString("tipo_incidente"),
						resultado.getInt("id_funcionario"), resultado.getString("status"),
						resultado.getString("resolucao"));
				chamados.add(chamado);
			}
			return chamados;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Chamado> getAllChamadosFinalizados() {
		ArrayList<Chamado> chamados = new ArrayList<Chamado>();
		try {
			Statement executarCapturaChamados = conexao.createStatement();
			// Traz os valores do banco de dados
			ResultSet resultado = executarCapturaChamados
					.executeQuery("select * from chamado where status ='-Resolvido-';");
			// Faz um for para preencher o objeto
			while (resultado.next()) {
				Chamado chamado = new Chamado(resultado.getInt("id_numero_chamado"),
						resultado.getString("nome_cliente"), resultado.getString("descricao"),
						resultado.getString("notificacao"), resultado.getString("tipo_incidente"),
						resultado.getInt("id_funcionario"), resultado.getString("status"),
						resultado.getString("resolucao"));
				chamados.add(chamado);
			}
			return chamados;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		ChamadoDAO dao = new ChamadoDAO();
		dao.getAllChamados();
	}
}