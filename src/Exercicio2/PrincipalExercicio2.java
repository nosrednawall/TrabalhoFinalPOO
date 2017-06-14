package Exercicio2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PrincipalExercicio2 {

	static Map<Integer, Aluno> dados;

	public static void main(String[] args) {
		dados = new TreeMap<Integer, Aluno>();
		//Selecao();
		
		Aluno aluno1 = new Aluno();
		aluno1.setAg(10);
		aluno1.setCpf(1010);
		aluno1.setIdade(13);
		aluno1.setNome("Carlos Magno");
		
		
		Aluno aluno2 = new Aluno();
		aluno2.setAg(123123);
		aluno2.setCpf(3233213);
		aluno2.setIdade(66);
		aluno2.setNome("Luis Capeto");
		
		
		
		adicionaAluno(aluno2);
		adicionaAluno(aluno1);
		
		
		listarDados();
		
		removeAluno(aluno2);
		listarDados();

	}

	public static String TextoInicial() {
		System.out.print("--------------------------" + "\nCRUD Aluno\n" + "Por favor escolha uma das opções abaixo: \n"
				+ "1\tAdicionar\n" + "2\tConsultar\n" + "3\tListar\n" + "4\tAtualizar\n");
		return null;
	}

	public static void Selecao() {
		TextoInicial();
		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:

			break;

		default:
			System.out.println("Por favor escolha entre 1 a 10");
			break;
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
		System.out.println("O Aluno "+aluno.nome +" foi adicionado com sucesso ");
		return;

	}

}
