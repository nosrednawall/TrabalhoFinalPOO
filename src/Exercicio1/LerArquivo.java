package Exercicio1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class LerArquivo {

	static String texto;
	static int porta = 12258;

	@SuppressWarnings("static-access")
	public static void LendoArquivo(String arquivo) {
		try {

			@SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(porta);
			Socket conexao = servidor.accept();
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			SocketAddress s = conexao.getRemoteSocketAddress();
			
			System.out.println("Passou");
			System.out.println("Enviando arquivo ao cliente" + s.toString());

			Thread.currentThread().sleep(5000);
			
			FileReader ler = new FileReader(new File(arquivo));
			BufferedReader leitor = new BufferedReader(ler);
			String texto = leitor.readLine();
			while (true) {
				if (texto != null) {
					saida.writeUTF(texto);
					//texto = leitor.readLine();
					//System.out.printf("%s\n", texto);
				} else {
					break;
				}
				texto = leitor.readLine();
			}
			ler.close();
			conexao.close();
			saida.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
