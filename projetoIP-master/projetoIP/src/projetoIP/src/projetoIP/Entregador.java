package projetoIP;


public class Entregador extends Funcionarios {

	private String cpf = null;
	private double salario = 0;
	private double rendimento = 0;
	private int reclamacoes = 0;
	private boolean beneficios = true;
	
	public Entregador(String cpf){this.cpf = cpf;}
	public void rendimento (double valor) {this.rendimento += valor;}
	public void salario () {this.salario += (this.rendimento * 0.15);}
	public double getSalario() {return this.salario;}
	public void reclamacoes (String reclamacao) {if (!reclamacao.equals(null)){this.reclamacoes += 1;}}
	public void beneficios () {if (this.reclamacoes >= 19) {this.beneficios = false;}}
}
