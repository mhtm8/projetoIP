package Repositorio;
import projetoIP.Funcionarios;
public class RepositorioFuncionariosArray implements RepositorioFuncionarios  {

	public Funcionarios[] funcionario = new Funcionarios[40];
	int indice = 0;
	public void inserir (Funcionarios f) {
		funcionario[indice] = f;
		indice += 1;
	}
	public Funcionarios procurar (String cpf, int i) {
		if(funcionario[i].getCpf().equals(cpf)) {
			return funcionario[i];
		}
		else {
			return procurar(cpf, i + 1);
		}
	}
	public void remover (String cpf) {
		for (int i = 0; i < funcionario.length; i++) {
			if (funcionario[i].getCpf().equals(cpf)) {
				this.funcionario[i] = null;
			}
		}
		for (int i = 0; i < funcionario.length; i++) {
			for (int j = 0; j < funcionario.length; j++) {
				if (this.funcionario[j]== null && this.funcionario[i + 1] != null) {
					this.funcionario[j] = this.funcionario[j + 1];
					this.funcionario[j + 1] = null;
				}
			}
		}
	}
	public void atualizar (Funcionarios f) {
		for (int i = 0; i < funcionario.length; i++) {
			if(this.funcionario[i].getCpf().equals(f.getCpf())) {
				this.funcionario[i] = f;
			}
		}
	}
}
