package examples.sockettcp02;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) throws Throwable {

		//criação do servidor
		ServerSocket ss = new ServerSocket(6700);		
		System.out.println("[SERVIDOR] Esperando por conexao de cliente...");
		Socket socket = ss.accept();
		System.out.println("[SERVIDOR] Cliente se conectou");
		
		//Objeto de leitura
		ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());		
		String saida = "";
		do{
			Mensagem mensagem = (Mensagem) entrada.readObject();
			System.out.println("[SERVIDOR]: Recebido do Cliente: Assunto: " + mensagem.getAssunto()+", Mensagem: " + mensagem.getMensagem());
			saida = mensagem.getAssunto();
		}while(!saida.equals("FIM"));
		
		entrada.close();
		ss.close();
		System.out.println("[SERVIDOR]: Servidor Encerrado");

	}

}
