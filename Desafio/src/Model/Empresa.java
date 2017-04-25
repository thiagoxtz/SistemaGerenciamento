package Model;

public class Empresa {
	private String nomeEmpresa;
	private String funcaoEmpresa;
	private double centroCustoEmpresa;
	private String responsabilidadeEmpresa;

	public Empresa (String nomeEmpresa, String funcaoEmpresa, double centroCustoEmpresa,
			String responsabilidadeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
		this.funcaoEmpresa = funcaoEmpresa;
		this.centroCustoEmpresa = centroCustoEmpresa;
		this.responsabilidadeEmpresa = responsabilidadeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeEmpresa() {
		return this.nomeEmpresa;
	}

	public void setFuncaoEmpresa(String funcaoEmpresa) {
		this.funcaoEmpresa = funcaoEmpresa;
	}

	public String getFuncaoEmpresa() {
		return this.funcaoEmpresa;
	}

	public void setCentroCustoEmpresa(String funcaoEmpresa) {
		this.funcaoEmpresa = funcaoEmpresa;
	}

	public double getCentroCustoEmpresa() {
		return this.centroCustoEmpresa;
	}

	public void setResponsabilidadeEmpresa(String responsabilidadeEmpresa) {
		this.responsabilidadeEmpresa = responsabilidadeEmpresa;
	}

	public String getResponsabilidadeEmpresa() {
		return this.responsabilidadeEmpresa;
	}

}
