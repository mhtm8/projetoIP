package Repositorio;

import projetoIP.Clientes;

public interface RepositorioCliente {

	public void inserir (Clientes c);
	public Clientes procurar (String cpf, int i);
	public void atualizar (Clientes c);
	public void remover (String cpf);
}
