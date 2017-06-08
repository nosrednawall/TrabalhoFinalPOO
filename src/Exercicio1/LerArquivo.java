package Exercicio1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketAddress;

public class LerArquivo {
	
	static String texto;
	
	public LerArquivo() {
		
		File arquivo = new File("arq.txt");
		FabricaConexoes conexao = new FabricaConexoes();
		
		try {
			FileReader ler = new FileReader(arquivo);
			BufferedReader leitor = new BufferedReader(ler);
			while (leitor.ready()) {
				//System.out.println(leitor.readLine());
				texto=leitor.readLine();
				conexao.CriarConexao();
				DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
				SocketAddress s = conexao.getRemoteSocketAddress();
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
