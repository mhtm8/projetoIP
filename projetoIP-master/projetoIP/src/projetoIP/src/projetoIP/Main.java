package projetoIP;

import java.util.Scanner;

import Repositorio.RepoditorioLista;
import Repositorio.RepositorioArray;
import Repositorio.RepositorioFuncionarioLista;
import Repositorio.RepositorioFuncionariosArray;
import repositorioGerenciamento.RepositorioGerenciamentoArray;
import repositorioGerenciamento.RepositorioGerenciamentoLista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String decisao = "";
		boolean encerrar = false;
		String resp = "";
		
		String aux = "";
		int auxint = 0;
		
		RepoditorioLista rcl = new RepoditorioLista();
		RepositorioArray c = new RepositorioArray();
		RepositorioGerenciamentoArray rga = new RepositorioGerenciamentoArray();
		RepositorioGerenciamentoLista rgl = new RepositorioGerenciamentoLista();
		RepositorioFuncionarioLista fl = new RepositorioFuncionarioLista();
		RepositorioFuncionariosArray rfa = new RepositorioFuncionariosArray();
		
		Gerenciamento g = new Gerenciamento();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("O programa dever� ser executado por array ou lista?");
		System.out.println("Digite 1 para Array");
		System.out.println("Digite 2 para Lista");
		System.out.println(" ");
		System.out.println("Instru��es:");
		System.out.println(" ");
		System.out.println("Digite 3 para cadastrar cliente;");
		System.out.println("Digite 4 para cadastrar funcion�rio;");
		System.out.println("Digite 5 para comprar de fornecedores;");
		System.out.println("Digite 6 para um cliente realizar uma compra;");
		System.out.println("Digite 7 para quitar uma d�vida;");
		System.out.println("Digite 8 para demitir um funcionario;");
		System.out.println("Digite 9 para excluir um cliente;");
		System.out.println("Digite 10 para registrar uma reclama��o;");
		System.out.println("Digite 0 para encerrar.");
		
		decisao = in.nextLine();
		
		if(decisao.equals("1")) {
			while(!encerrar) {
				resp = in.nextLine();
				
				if(resp.equals("3")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					Clientes a = new Clientes(aux);
					c.inserir(a);
				}
				else if(resp.equals("4")) {
					System.out.println("Qual � o tipo de funcion�rio?");
					aux = in.nextLine();
					
					if(aux.equals("ENTREGADOR")) {
						Funcionarios f = new Entregador(aux);
						
						rfa.inserir(f);
					}
					else if(aux.equals("COZINHEIRO")) {
						Funcionarios f = new Cozinheiro(aux);
						
						rfa.inserir(f);
					}
					else if(aux.equals("BALCONISTA")) {
						Funcionarios f = new Balconista(aux);
						
						rfa.inserir(f);
					}
				}
				else if(resp.equals("5")) {
					System.out.println("Digite o valor da compra:");
					int auxi = in.nextInt();
					if(!g.getMes().equals(null)) {
						g.compra(auxi);
					}
					else {
						System.out.println("Digite o m�s da compra:");
						aux = in.nextLine();
						
						g = rga.procurar(aux, 0);
						
						g.compra(auxi);
					}
					
				}
				else if(resp.equals("6")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					
					Clientes a = c.procurar(aux, 0);
					if(a.getConta() > 0) {
						
						System.out.println("Digite o valor da compra:");
						auxint = in.nextInt();
						
						System.out.println("Digite a forma de compra:");
						aux = in.nextLine();
						
						if(aux.equals("A VISTA")) {
							System.out.println("Digite o valor que deseja pagar:");
							int auxii = in.nextInt();
							
							if(a.comprarVista(auxint, auxii)) {
								System.out.println("Compra realizada com sucesso!");
							}
							else {
								if(a.comprarFiado(auxint - auxii)) {
									System.out.println("o valor de " + (auxint - auxii) + " foi redirecionado � conta de " + a.getCpf() + ". Agora a conta dele� � " + a.getConta()+ ".");
								}
								else {
									System.out.println("N�o foi poss�vel realizar a compra!");
								}
							}
						}
						else if(aux.equals("FIADO")) {
							if(a.comprarFiado(auxint)) {
								System.out.println("o valor de " + auxint + " foi redirecionado � conta de " + a.getCpf() + ". Agora a conta dele� � " + a.getConta()+ ".");
							}
							else {
								System.out.println("N�o foi poss�vel realizar a compra!");
							}
						}
						
						System.out.println("O cliente de CPF: " + aux + " tem uma conta de " + a.getConta() + " pendente. Deseja quitar essa d�vida?");
						aux = in.nextLine();
						
						if(aux.equals("SIM")) {
							System.out.println("Digite o valor que deseja pagar:");
							auxint = in.nextInt();
							
							a.quitarDivida(auxint);
							
							System.out.println("A d�vida do cliente "+ a.getCpf() +" agora � de " + a.getConta()+ " reais.");
						}
						else {
							a.reduzFidelelidade();
						}
					}
				}
				else if(resp.equals("7")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					
					Clientes a = c.procurar(aux, 0);
					
					System.out.println("A d�vida do cliente " + a.getCpf() + " � de " + a.getConta() + ". Quanto deseja pagar?");
					auxint = in.nextInt();
					
					a.quitarDivida(auxint);
					
					System.out.println("A d�vida do cliente " + a.getCpf() + " agora � de " + a.getConta() + ".");
				}
				else if(resp.equals("8")) {
					System.out.println("Digite o CPF do funcion�rio:");
					aux = in.nextLine();
					
					rfa.remover(aux);
					
					System.out.println("Funcion�rio Demitido!");
				}
				else if(resp.equals("9")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					
					c.remover(aux);
					
					System.out.println("Cliente exclu�do!");
				}
				else if(resp.equals("10")) {
					System.out.println("Digite o CPF do funcionario alvo da reclama��o:");
					aux = in.nextLine();
					
					System.out.println("Digite a reclama��o: ");
					String auxs = in.nextLine();
					auxs += aux;
					
					System.out.println("Digite o m�s refente a reclama��o:");
					aux = in.nextLine();
					
					g = rga.procurar(aux, 0);
					g.adicionarreclamacao(auxs);
				}
				else if(resp.equals("0")) {
					encerrar = true;
				}
				else {
					System.out.println("Resposta Inv�lida!");
				}
			}
		}
		else if(decisao.equals("2")) {
			while(!encerrar) {
				resp = in.nextLine();
				
				if(resp.equals("3")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					Clientes a = new Clientes(aux);
					rcl.inserir(a);
				}
				else if(resp.equals("4")) {
					System.out.println("Qual � o tipo de funcion�rio?");
					aux = in.nextLine();
					
					if(aux.equals("ENTREGADOR")) {
						Funcionarios f = new Entregador(aux);
						
						fl.inserir(f);
					}
					else if(aux.equals("COZINHEIRO")) {
						Funcionarios f = new Cozinheiro(aux);
						
						fl.inserir(f);
					}
					else if(aux.equals("BALCONISTA")) {
						Funcionarios f = new Balconista(aux);
						
						fl.inserir(f);
					}
				}
				
				else if(resp.equals("5")) {
					System.out.println("Digite o valor da compra:");
					int auxi = in.nextInt();
					if(!g.getMes().equals(null)) {
						g.compra(auxi);
					}
					else {
						System.out.println("Digite o m�s da compra:");
						aux = in.nextLine();
						
						g = rga.procurar(aux, 0);
						
						g.compra(auxi);
					}
					
				}
				else if(resp.equals("6")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					
					Clientes a = rcl.procurar(aux, 0);
					if(a.getConta() > 0) {
						
						System.out.println("Digite o valor da compra:");
						auxint = in.nextInt();
						
						System.out.println("Digite a forma de compra:");
						aux = in.nextLine();
						
						if(aux.equals("A VISTA")) {
							System.out.println("Digite o valor que deseja pagar:");
							int auxii = in.nextInt();
							
							if(a.comprarVista(auxint, auxii)) {
								System.out.println("Compra realizada com sucesso!");
							}
							else {
								if(a.comprarFiado(auxint - auxii)) {
									System.out.println("o valor de " + (auxint - auxii) + " foi redirecionado � conta de " + a.getCpf() + ". Agora a conta dele� � " + a.getConta()+ ".");
								}
								else {
									System.out.println("N�o foi poss�vel realizar a compra!");
								}
							}
						}
						else if(aux.equals("FIADO")) {
							if(a.comprarFiado(auxint)) {
								System.out.println("o valor de " + auxint + " foi redirecionado � conta de " + a.getCpf() + ". Agora a conta dele� � " + a.getConta()+ ".");
							}
							else {
								System.out.println("N�o foi poss�vel realizar a compra!");
							}
						}
						
						System.out.println("O cliente de CPF: " + aux + " tem uma conta de " + a.getConta() + " pendente. Deseja quitar essa d�vida?");
						aux = in.nextLine();
						
						if(aux.equals("SIM")) {
							System.out.println("Digite o valor que deseja pagar:");
							auxint = in.nextInt();
							
							a.quitarDivida(auxint);
							
							System.out.println("A d�vida do cliente "+ a.getCpf() +" agora � de " + a.getConta()+ " reais.");
						}
						else {
							a.reduzFidelelidade();
						}
					}
				}
				else if(resp.equals("7")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					
					Clientes a = c.procurar(aux, 0);
					
					System.out.println("A d�vida do cliente " + a.getCpf() + " � de " + a.getConta() + ". Quanto deseja pagar?");
					auxint = in.nextInt();
					
					a.quitarDivida(auxint);
					
					System.out.println("A d�vida do cliente " + a.getCpf() + " agora � de " + a.getConta() + ".");
				}
				else if(resp.equals("8")) {
					System.out.println("Digite o CPF do funcion�rio:");
					aux = in.nextLine();
					
					fl.remover(aux);
					System.out.println("Funcionario removido!");
				}
				else if(resp.equals("9")) {
					System.out.println("Digite o CPF do cliente:");
					aux = in.nextLine();
					
					Clientes a = c.procurar(aux, 0);
					
					System.out.println("Cliente exclu�do!");
				}
				else if(resp.equals("10")) {
					System.out.println("Digite o CPF do funcionario alvo da reclama��o:");
					aux = in.nextLine();
					
					System.out.println("Digite a reclama��o: ");
					String auxs = in.nextLine();
					auxs += aux;
					
					Funcionarios f = fl.procurar(aux, 0);
					f.reclamacoes(aux);
					
					System.out.println("Digite o m�s refente a reclama��o:");
					aux = in.nextLine();
					
					g = rga.procurar(aux, 0);
					g.adicionarreclamacao(auxs);
				}
				else if(resp.equals("0")) {
					encerrar = true;
				}
				else {
					System.out.println("Resposta Inv�lida!");
				}
			}
		}
		else {
			System.out.println("Resposta Inv�lida.");
		}
		
	}

}
