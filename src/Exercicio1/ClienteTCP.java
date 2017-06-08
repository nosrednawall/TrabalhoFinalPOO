package Exercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteTCP {

	public ClienteTCP() {
		
		String enderecoServidor = "meu ip";
		int portaServidor = 12258;
		String saida;
		
		try {
			Thread.currentThread().sleep(50000);
			Socket conexao = new Socket(enderecoServidor,portaServidor);
			DataInputStream entrada = new DataInputStream(
					conexao.getInputStream());
			while((saida = entrada.readUTF())!=null){
				System.out.println("Valor recebido = "+saida);
			}
			conexao.close();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
