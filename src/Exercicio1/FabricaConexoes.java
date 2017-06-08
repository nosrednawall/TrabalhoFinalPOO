package Exercicio1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class FabricaConexoes {
	int porta = 12258;

	void CriarConexao() {

		ServerSocket servidor;
		try {
			
			servidor = new ServerSocket(porta, 2);
			Socket conexao = servidor.accept();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;

	}

	public SocketAddress getRemoteSocketAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public OutputStream getOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}


}
