package projetoIP;

public class Balconista extends Funcionarios {
	
	private double salario = 0;
	private double rendimento = 0;
	private int reclamacoes = 0;
	private boolean beneficios = true;
	
	public void rendimento (double valor) {this.rendimento += valor;}
	public void salario () {this.salario += (this.rendimento * 0.2);}
	public void reclamacoes (String reclamacao) {if (!reclamacao.equals(null)){this.reclamacoes += 1;}}
	public void beneficios () {if (this.reclamacoes >= 19) {this.beneficios = false;}}
}
