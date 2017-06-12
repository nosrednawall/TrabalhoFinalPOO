package Exercicio1;

public class PrincipalExercicioArquivo {

	public static void main(String[] args) {
		String arquivo = "/home/Anderson/workspace/TrabalhoFinal/arq.txt";
		int porta = 12258;
		LerArquivo.LendoArquivo(arquivo);
		LerArquivo.EnviandoArquivo(porta);
	}
}