package repositorio;
import projetoIP.Funcionarios;
public interface RepositorioFuncionarios {
	public void inserir (Funcionarios f);
	public Funcionarios procurar (String cpf, int i);
	public void remover (String cpf);
	public void atualizar (Funcionarios f);
}
