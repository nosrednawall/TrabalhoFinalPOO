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

	public static void LendoArquivo(String arquivo) {
		try {
			FileReader ler = new FileReader(new File(arquivo));
			BufferedReader leitor = new BufferedReader(ler);
			String texto = leitor.readLine();
			while (true) {
				if (texto != null) {
					//System.out.printf("%s\n", texto);
				} else {
					break;
				}
				texto = leitor.readLine();
			}
			ler.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void EnviandoArquivo(int porta){
		try {
			@SuppressWarnings("resource")
			ServerSocket servidor = new ServerSocket(porta);
			Socket conexao = servidor.accept();
			DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
			SocketAddress s = conexao.getRemoteSocketAddress();
			System.out.println("Passou");
			System.out.println("Enviando arquivo ao cliente"+s.toString());
			saida.writeUTF(texto);
			saida.flush();
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*
 * int porta = 12258; ServerSocket servidor;
 * 
 * 
 * 
 * servidor = new ServerSocket(porta, 2); Socket conexao = servidor.accept();
 * DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
 * SocketAddress s = conexao.getRemoteSocketAddress();
 */