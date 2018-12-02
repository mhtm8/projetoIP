package projetoIP;

public class Cozinheiro extends Funcionarios {

	private String cpf = null;
	private double salario = 0;
	private double rendimento = 0;
	private int reclamacoes = 0;
	private boolean beneficios = true;
	
	public Cozinheiro (String cpf) {this.cpf = cpf;}
	public void rendimento (double valor) {this.rendimento += valor;}
	public void salario () {this.salario += (this.rendimento * 0.1);}
	public double getSalario() {return this.salario;}
	public void reclamacoes (String reclamacao) {if (!reclamacao.equals(null)){this.reclamacoes += 1;}}
	public void beneficios () {if (this.reclamacoes >= 19) {this.beneficios = false;}}
	
}
