package Model;

public class Funcionario {
	private String nomeFuncionario;
	private int idFuncionario;
	private String setorFuncionario;

	public Funcionario(String nomeFuncionario, int idFuncionario, 
			String setorFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
		this.idFuncionario = idFuncionario;
		this.setorFuncionario = setorFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getNomeFuncionario() {
		return this.nomeFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public int getIdFuncionario(){
		return this.idFuncionario;
	}
	
	public void setSetorFuncionario(String setorFuncionario){
		this.setorFuncionario = setorFuncionario;
	}
	public String getSetorFuncionario(){
		return this.setorFuncionario;
	}
	
	
	
}
