package repositorioGerenciamento;

import projetoIP.Clientes;
import projetoIP.Gerenciamento;

public interface RepositorioGerenciamento {

	public void inserir (Gerenciamento g);
	public Clientes procurar (String mes, int i);
	public void atualizar (Gerenciamento g);
	public void remover (String mes);
	
}
