package Model;

public class Chamado {

	private int idNumeroChamado;
	private String nomeCliente;
	private String descricao;
	private String notificacao;
	private String tipoIncidente;
	private int idFuncionario;
	private String status;
	private String resolucao;

	public Chamado(int idNumeroChamado, String cliente, String descChamado, String notificacao, String tipoIncidente,
			int idFuncionario, String status, String resolucao) {

		this.idNumeroChamado = idNumeroChamado;
		this.nomeCliente = cliente;
		this.descricao = descChamado;
		this.notificacao = notificacao;
		this.tipoIncidente = tipoIncidente;
		this.idFuncionario = idFuncionario;
		this.status = status;
		this.resolucao = resolucao;
	}

	public int getIdNumeroChamado() {
		return idNumeroChamado;
	}

	public void setIdNumeroChamado(int idNumeroChamado) {
		this.idNumeroChamado = idNumeroChamado;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(String notificacao) {
		this.notificacao = notificacao;
	}

	public String getTipoIncidente() {
		return tipoIncidente;
	}

	public void setTipoIncidente(String tipoIncidente) {
		this.tipoIncidente = tipoIncidente;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}
}