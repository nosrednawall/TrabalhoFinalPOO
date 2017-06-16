package Exercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class PrincipalExercicio2 {

	static Map<Integer, Aluno> dados;

	public static void main(String[] args) {
		dados = new TreeMap<Integer, Aluno>();
		
		Aluno aluno = new Aluno();
		aluno.setNome("Luis Capeto");
		aluno.setAg(10101);
		aluno.setCpf(1234);
		aluno.setIdade(22);
		adicionaAluno(aluno);		

		Selecao();
	}

	public static String TextoInicial() {
		System.out.print("--------------------------" + "\nCRUD Aluno\n" + "Por favor escolha uma das opções abaixo: \n"
				+ "1\tAdicionar\n" + "2\tConsultar\n" + "3\tListar\n" + "4\tAtualizar\n" + "5\tSair\n");
		return null;
	}

	public static void Selecao() {
		TextoInicial();
		String resposta = "no";
		int opcao = 0;
		while (opcao != 5) {
			Scanner sc = new Scanner(System.in);
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:	
				System.out.println("Criando aluno");
				CriaAluno();
				break;

			case 2:
				boolean  alunoEditado = false;
				System.out.println("Consultando o aluno");
				while (alunoEditado != true) {
					System.out.println("Informe o número do AG do aluno");
					int numeroAg = sc.nextInt();
					consultaAluno(numeroAg);
					alunoEditado=true;
				}
				System.out.println("Saindo");
				break;
			
			case 3:
				System.out.println("Listando alunos cadastrados");
				listarDados();
				System.out.println("Saindo");
				break;
			
			case 4:
				boolean  alunoEditado1 = false;
				System.out.println("Atualizando dados");
				
				while (alunoEditado1 != true) {
					System.out.println("Informe o número do AG do aluno");
					int numeroAg = sc.nextInt();
					EditarAluno(numeroAg);
					alunoEditado1=true;
				}
				
				break;
				
				
			default:
				TextoInicial();
				break;
			}

		}

	}

	private static void listarDados() {
		List<Aluno> lista = new ArrayList<Aluno>(dados.values());
		Iterator<Aluno> itr = lista.iterator();
		while (itr.hasNext()) {
			Aluno aluno = (Aluno) itr.next();
			System.out.println(aluno.getAg() + " " + aluno.getNome());

		}

	}

	@SuppressWarnings("unused")
	private static void removeAluno(Aluno aluno) {
		dados.remove(aluno.getAg(), aluno);

	}

	private static void adicionaAluno(Aluno aluno) {
		dados.put(aluno.getAg(), aluno);
		System.out.println("O Aluno " + aluno.nome + " foi adicionado com sucesso ");
		return;

	}

	private static void consultaAluno(int ag) {
		List<Aluno> lista = new ArrayList<Aluno>(dados.values());
		Iterator<Aluno> itr = lista.iterator();
		while (itr.hasNext()) {
			Aluno aluno = (Aluno) itr.next();
			if (aluno.ag == ag) {
				System.out
						.println("\nO aluno foi encontrado\n Segue abaixo os dados solicitados\n nome:\t " + aluno.nome
								+ "\nAG:\t" + aluno.ag + "\nIdade:\t" + aluno.idade + "\nCPF:\t" + aluno.cpf + "\n");
				break;
			}
		}
	}
	
	
	private static void EditarAluno(int ag) {
		List<Aluno> lista = new ArrayList<Aluno>(dados.values());
		Iterator<Aluno> itr = lista.iterator();
		while (itr.hasNext()) {
			Aluno aluno = (Aluno) itr.next();
			if (aluno.ag == ag) {
				System.out
						.println("\nO aluno foi encontrado\n Segue abaixo os dados solicitados\n nome:\t " + aluno.nome
								+ "\nAG:\t" + aluno.ag + "\nIdade:\t" + aluno.idade + "\nCPF:\t" + aluno.cpf + "\n");
				CriaAluno();
				System.out.print("Alterações efetuadas com sucesso!\nNome\t"+aluno.nome
						+ "\nAG:\t" + aluno.ag + "\nIdade:\t" + aluno.idade + "\nCPF:\t" + aluno.cpf + "\n");
				break;
			}
		}
	}
	
	private static void CriaAluno(){
		String resposta = "no";
		boolean nome = false, ag = false, idade = false, cpf = false;
		
		Scanner sc = new Scanner(System.in);
		
		while (!resposta.equals("yes")) {
			Aluno aluno = new Aluno();

			while (nome != true) {
				System.out.println("Por favor informe o nome do aluno");
				sc.nextLine();
				aluno.setNome(sc.next());
				if (aluno.nome.equals(null)) {
					System.out.println("Por favor informe o nome do aluno");
					sc.nextLine();
					aluno.setNome(sc.next());
				} else {
					nome = true;
				}
			}
			while (cpf != true) {
				System.out.println("Agora informe o CPF do aluno " + aluno.nome);
				sc.nextLine();
				aluno.setCpf(sc.nextInt());
				if (aluno.cpf <= 0) {
					System.out.println("Por favor insira um CPF válido");
					sc.nextLine();
					aluno.setCpf(sc.nextInt());
				} else {
					cpf = true;
				}
			}
			while (idade != true) {
				System.out.println("Agora informe a idade do aluno " + aluno.nome);
				sc.nextLine();
				aluno.setIdade(sc.nextInt());
				if (aluno.idade <= 9) {
					System.out.println("Por favor insira uma idade válida");
					sc.nextLine();
					aluno.setIdade(sc.nextInt());
				} else {
					idade = true;
				}

			}
			while (ag != true) {
				System.out.println("Informe qual será o número do AG do aluno " + aluno.nome);
				sc.nextLine();
				aluno.setAg(sc.nextInt());
				if (aluno.ag <= 0) {
					System.out.println("Insira um AG válido");
					sc.nextLine();
					aluno.setAg(sc.nextInt());
				} else {
					ag = true;
				}
			}
			System.out.print("\nAs os dados abaixo estão corretos?\n" + "nome:\t" + aluno.nome + "\nAG:\t"
					+ aluno.ag + "\nIdade:\t" + aluno.idade + "\nCPF:\t" + aluno.cpf
					+ "\n Responta s para sim e n para não\n");
			sc.nextLine();
			resposta = sc.next();

			if (!resposta.equals("s") && !resposta.equals("n")) {
				System.out.println("Não compreendi a sua resposta\nPorfavor informe se é sim s, ou não n");
				sc.nextLine();
				resposta = sc.next();

				if (!resposta.equals("s") && !resposta.equals("n")) {
					System.out.println(
							"Não compreendi a sua resposta\nMais uma resposta errada e os dados serão zerados\n"
									+ "Sim isso é uma ameaça, então responda corretamente\n"
									+ "Por favor informe se é sim s, ou não n");
					sc.nextLine();
					resposta = sc.next();
					if (!resposta.equals("s") && !resposta.equals("n")) {
						nome = false;
						ag = false;
						idade = false;
						cpf = false;
						System.out.println("Dados zerados, eu lhe avisei!");
					}
				}

			}

			if (resposta.equals("n")) {
				nome = false;
				ag = false;
				idade = false;
				cpf = false;
			}
			if (resposta.equals("s")) {
				resposta = "yes";
				adicionaAluno(aluno);
			}
		}
		
		
		
	}
	
	
}
