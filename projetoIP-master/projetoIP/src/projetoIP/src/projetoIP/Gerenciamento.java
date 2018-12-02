package projetoIP;

public class Gerenciamento {

	private String mes;
	private double custo;
	private double totalVenda;
	private double lucro;
	private int i;
	
	private String reclamacoes[] = new String [40];
	
	Gerenciamento(){
		i = 0;
	}
	public String getMes() {
		return this.mes;
	}
	public void compra (int valor) {
		this.custo += valor;
	}
	
	public void totall (int valor) {
		this.totalVenda += valor;
	}
	
	public void lucrol() {
		this.lucro = totalVenda - custo;
	}
	
	public void totalCusto(Funcionarios[] f) {
		
	}
	
	public void adicionarreclamacao (String reclamacao) {
		reclamacoes[i] = reclamacao;
		i += 1;
	}
	
	public String[] getReclamacao(){
		return reclamacoes;
	}

}
