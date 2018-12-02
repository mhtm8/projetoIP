package repositorioGerenciamento;

import projetoIP.Gerenciamento;

public class RepositorioGerenciamentoLista {

	private Gerenciamento gerenciamento;
	private RepositorioGerenciamentoLista proximo;
	
	public RepositorioGerenciamentoLista(){
		this.gerenciamento = null;
		this.proximo = null;
	}
	
	public void inserir (Gerenciamento g) {
		if(this.gerenciamento == null) {
			this.gerenciamento = g;
		}
		else {
			this.proximo.inserir(g);
		}
	}
	
	public Gerenciamento procurar (String mes, int i) {
		if(this.gerenciamento.getMes().equals(mes)) {
			return this.gerenciamento;
		}
		else {
			return this.proximo.procurar(mes,i);
		}
	}
	
	public void atualizar (Gerenciamento g) {
		if(g.getMes().equals(this.gerenciamento.getMes())) {
			this.gerenciamento = g;
		}
		else {
			this.proximo.atualizar(g);
		}
	}
	
	public void remover (String mes) {
		if(this.gerenciamento.getMes().equals(mes)) {
			this.gerenciamento = null;
			this.proximo = this.proximo.proximo;
		}
		else {
			this.proximo.remover(mes);
		}
	}
}
