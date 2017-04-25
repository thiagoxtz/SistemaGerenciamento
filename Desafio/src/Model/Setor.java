package Model;

import java.util.ArrayList;
import java.util.List;

public class Setor {

		private String nomeSetor;
		private int idSetor;
		private List<Funcionario> funcionarios;
		
		public Setor(String nomeSetor, int idSetor){
			this.funcionarios = new ArrayList<Funcionario>();
			this.nomeSetor = nomeSetor;
			this.idSetor = idSetor;
		}

		public String getNomeSetor() {
			return nomeSetor;
		}

		public void setNomeSetor(String nomeSetor) {
			this.nomeSetor = nomeSetor;
		}

		public int getIdSetor() {
			return idSetor;
		}

		public void setIdSetor(int idSetor) {
			this.idSetor = idSetor;
		}

		public List<Funcionario> getFuncionarios() {
			return funcionarios;
		}

		public void setFuncionarios(List<Funcionario> funcionarios) {
			this.funcionarios = funcionarios;
		}
		
		public void addFuncionarioSetor(Funcionario funcionarios){
			this.funcionarios.add(funcionarios);
		}
}
