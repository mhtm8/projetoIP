package repositorio;
import projetoIP.Funcionarios;
public class RepositorioLista implements RepositorioFuncionarios {
	
	private Funcionarios funcionario;
	private RepositorioLista proximo;
	
	RepositorioLista(){
		this.funcionario = null;
		this.proximo = null;
	}
	public void inserir (Funcionarios f) {
		if(this.funcionario == null) {
			this.funcionario = f;
		}
		else {this.proximo.inserir(f);}
	}
	public Funcionarios procurar (String cpf, int i) {
		if(this.funcionario.getCpf().equals(cpf)) {
			return this.funcionario;
		}
		else {return this.proximo.procurar(cpf, i);}
	}
	public void remover (String cpf) {
		if(this.funcionario.getCpf().equals(cpf)) {
			this.funcionario = null;
			this.proximo = this.proximo.proximo;
		}
		else {this.proximo.remover(cpf);}
	}
	public void atualizar (Funcionarios f) {
		if(f.getCpf().equals(this.funcionario.getCpf())) {
			this.funcionario = f;
		}
		else {this.proximo.atualizar(f);}
	}
}
