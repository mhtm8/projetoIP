package projetoIP;

public class Clientes {

	private String cpf;
	private int conta;
	private double fidelidade;
	private double assiduidade;
	
	public Clientes(String cpf) {
		this.cpf = cpf;
		this.conta = 0;
		this.fidelidade = 7;
		this.assiduidade = 0;
	}
	
	public int getConta() {
		return this.conta;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public boolean comprarFiado(int valor) {
		if(this.fidelidade >= 7) {
			conta += valor;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void reduzFidelelidade () {
		this.fidelidade -= this.fidelidade * 0.1;
	}
	
	public void quitarDivida(int valor) {
		this.conta -= valor;
		this.fidelidade += this.fidelidade * 0.1;
	}
	
	public boolean comprarVista (int valor, int total) {
		if(total == valor) {
			return true;
		}
		else {
			return false;
		}
	}
}
