package Exercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mapas {

	static Map<Integer, Aluno> dados;

	public static void main(String[] args) {

		dados = new TreeMap<Integer, Aluno>();

		Aluno aluno1 = new Aluno();
		aluno1.setAg(100);
		aluno1.setNome("João Ferro");
		aluno1.setCpf(10);
		aluno1.setIdade(12);

		Aluno aluno2 = new Aluno();
		aluno1.setAg(100);
		aluno1.setNome("Carmen lúcida");
		aluno1.setCpf(66);
		aluno1.setIdade(66);

		adicionaAluno(aluno1);
		adicionaAluno(aluno1);
		// removeAluno(aluno2);
		listarDados();
		System.out.println("Chegou no final");

	}

	private static void atualizaAluno() {

	}

	private static void listarDados() {
		List<Aluno> lista = new ArrayList<Aluno>(dados.values());
		Iterator<Aluno> itr = lista.iterator();
		while (itr.hasNext()) {
			Aluno aluno = (Aluno) itr.next();
			System.out.println(aluno.getAg() + " " + aluno.getNome());

		}

	}

	private static void removeAluno(Aluno aluno) {
		dados.put(aluno.getAg(), aluno);

	}

	private static void adicionaAluno(Aluno aluno) {
		dados.remove(aluno.getAg());

	}

}