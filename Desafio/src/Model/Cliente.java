package Model;

public class Cliente {

	private String nomeCliente;
	private double idadeCliente;
	private String enderecoCliente;
	private int idCliente;
	private int ramalCliente;

	public Cliente(String nomeCliente, double idadeCliente, int idCliente, String enderecoCliente, int ramalCliente) {
		this.nomeCliente = nomeCliente;
		this.idadeCliente = idadeCliente;
		this.enderecoCliente = enderecoCliente;
		this.idadeCliente = idCliente;
		this.ramalCliente = ramalCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setIdadeCliente(double idadeCliente) {
		this.idadeCliente = idadeCliente;
	}

	public double getIdadeCliente() {
		return this.idadeCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getEnderecoCliente() {
		return this.enderecoCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdCliente(){
		return this.idCliente;
	}
	public void setRamalCliente(int ramalCliente){
		this.ramalCliente = ramalCliente;
	}
	public int getRamalCliente(){
		return this.ramalCliente;
	}

}
