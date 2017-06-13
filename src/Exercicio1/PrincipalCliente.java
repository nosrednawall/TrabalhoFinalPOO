package Exercicio1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PrincipalCliente {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		String enderecoServidor = "localhost";
		int portaServidor = 12258;
		String saida;
		String arquivo = "/home/Anderson/workspace/TrabalhoFinal/arq2.txt";
		String texto;
		try {

			FileWriter escrever = new FileWriter(arquivo);
			//BufferedWriter escreverBuff = new BufferedWriter(escrever);
			PrintWriter gravarArq = new PrintWriter(escrever);
			Thread.currentThread().sleep(5000);
			Socket conexao = new Socket(enderecoServidor, portaServidor);
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());

			while (true) {
				if ((saida = entrada.readUTF()) != null) {
					System.out.println(saida);
					//texto = saida + "\n";
					
					gravarArq.printf(saida+"\n");
					
					//escrever.write(texto);
					//escrever.newLine();
				} else {
					break;
				}
			}
			
			escrever.flush();
			escrever.close();
			entrada.close();
			conexao.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de rede");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de rede");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de sistema");
			e.printStackTrace();
		}

	}

}
