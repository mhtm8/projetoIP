package repositorioGerenciamento;

import projetoIP.Gerenciamento;

public class RepositorioGerenciamentoArray {

	public Gerenciamento[] gerencia = new Gerenciamento[40];
	
	int indice = 0;
	
	public void inserir (Gerenciamento c) {
		gerencia[indice] = c;
		indice += 1;
	}
	
	public Gerenciamento procurar (String mes, int i) {
		if(gerencia[i].getMes().equals(mes)) {
			return gerencia[i];
		}
		else {
			return procurar(mes, i + 1);
		}
	}
	public void atualizar (Gerenciamento g) {
		for (int i = 0; i < gerencia.length; i++) {
			if(this.gerencia[i].getMes().equals(g.getMes())) {
				this.gerencia[i] = g;
			}
		}
	}
	public void remover (String mes) {
		for (int i = 0; i < gerencia.length; i++) {
			if(gerencia[i].getMes().equals(mes)) {
				this.gerencia[i] = null;
			}
		}
		
		for (int i = 0; i < gerencia.length; i++) {
			for (int j = 0; j < gerencia.length - 1; j++) {
				if(this.gerencia[j] == null && this.gerencia[j + 1] != null) {
					this.gerencia[j] = this.gerencia[j + 1];
					this.gerencia[j+1] = null;
				}
			}
		}
	}
}
