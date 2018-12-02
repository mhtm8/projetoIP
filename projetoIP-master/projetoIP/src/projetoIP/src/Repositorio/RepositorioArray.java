package Repositorio;

import projetoIP.Clientes;

public class RepositorioArray implements RepositorioCliente {

	public Clientes[] cliente = new Clientes[40];
	
	int indice = 0;
	
	public void inserir (Clientes c) {
		cliente[indice] = c;
		indice += 1;
	}
	
	public Clientes procurar (String cpf, int i) {
		if(cliente[i].getCpf().equals(cpf)) {
			return cliente[i];
		}
		else {
			return procurar(cpf, i + 1);
		}
	}
	public void atualizar (Clientes c) {
		for (int i = 0; i < cliente.length; i++) {
			if(this.cliente[i].getCpf().equals(c.getCpf())) {
				this.cliente[i] = c;
			}
		}
	}
	public void remover (String cpf) {
		for (int i = 0; i < cliente.length; i++) {
			if(cliente[i].getCpf().equals(cpf)) {
				this.cliente[i] = null;
			}
		}
		
		for (int i = 0; i < cliente.length; i++) {
			for (int j = 0; j < cliente.length - 1; j++) {
				if(this.cliente[j] == null && this.cliente[j + 1] != null) {
					this.cliente[j] = this.cliente[j + 1];
					this.cliente[j+1] = null;
				}
			}
		}
	}
}
