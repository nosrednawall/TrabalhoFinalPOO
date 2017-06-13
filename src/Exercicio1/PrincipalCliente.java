package Exercicio1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
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
		try {

			File file = new File(arquivo);
			PrintWriter escrevendo = new PrintWriter(new BufferedWriter(new FileWriter(file)));

			Thread.currentThread().sleep(5000);

			Socket conexao = new Socket(enderecoServidor, portaServidor);
			DataInputStream entrada = new DataInputStream(conexao.getInputStream());
			
			while(true){
			
			if ((saida = entrada.readUTF()) != null) {
				escrevendo.print(saida);
				escrevendo.println();
			}else{
				break;
			}
			}
			escrevendo.flush();
			escrevendo.close();
			entrada.close();
			conexao.close();

			System.out.println("Saiu do loop");
		} catch (UnknownHostException e) {
			System.out.println("Erro de rede");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro de sistema");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
