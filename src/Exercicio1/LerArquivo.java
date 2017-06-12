package Exercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3343194996666033488L;
	static String texto;
	
	public LerArquivo() {
		System.out.println("Entrou no construtor");
		File arquivo = new File("arq.txt");

		try {
			FileReader ler = new FileReader(arquivo);
			BufferedReader leitor = new BufferedReader(ler);
			System.out.println("Entrou no try");
			
			String texto = leitor.readLine();

			while (texto != null) {
				System.out.printf("%s\n", texto);
				texto=leitor.readLine();	
			}
			System.out.println("Terminou com sucesso o while");
			ler.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
/*		int porta = 12258;
		ServerSocket servidor;
 * 				
 * 
 * 
 * 				servidor = new ServerSocket(porta, 2);
				Socket conexao = servidor.accept();
				DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
				SocketAddress s = conexao.getRemoteSocketAddress();
 */