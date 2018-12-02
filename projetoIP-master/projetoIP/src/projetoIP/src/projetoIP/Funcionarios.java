package projetoIP;

public abstract class Funcionarios {
	private double salario;
	private double rendimento;
	private int reclamacoes;
	private boolean beneficios;
	private String cpf;
	
	
	public String getCpf() {return this.cpf;}
	public abstract void salario ();
	public double getSalario() {return this.salario;}
	public abstract void rendimento (double valor);
	public abstract void reclamacoes (String reclamacoes);
	public abstract void beneficios ();
}
