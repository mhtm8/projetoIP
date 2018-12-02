package Repositorio;

import projetoIP.Clientes;

public class RepoditorioLista implements RepositorioCliente {

	private Clientes cliente;
	private RepoditorioLista proximo;
	
	public RepoditorioLista(){
		this.cliente = null;
		this.proximo = null;
	}
	
	public void inserir (Clientes c) {
		if(this.cliente == null) {
			this.cliente = c;
		}
		else {
			this.proximo.inserir(c);
		}
	}
	
	public Clientes procurar (String cpf, int i) {
		if(this.cliente.getCpf().equals(cpf)) {
			return this.cliente;
		}
		else {
			return this.proximo.procurar(cpf,i);
		}
	}
	
	public void atualizar (Clientes c) {
		if(c.getCpf().equals(this.cliente.getCpf())) {
			this.cliente = c;
		}
		else {
			this.proximo.atualizar(c);
		}
	}
	
	public void remover (String cpf) {
		if(this.cliente.getCpf().equals(cpf)) {
			this.cliente = null;
			this.proximo = this.proximo.proximo;
		}
		else {
			this.proximo.remover(cpf);
		}
	}
}

