package examples.sockettcp01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTCP01 {

	public static void main(String[] args) {
		try{
			ServerSocket servidor = new ServerSocket(6700);
			System.out.println("[SERVIDOR] Esperando por conexao de cliente...");
			Socket socket = servidor.accept();
			System.out.println("[SERVIDOR] Cliente se conectou");

			//leitura do socket
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String msg = in.readUTF();
			System.out.println("[SERVIDOR] Mensagem do cliente" 
			+ socket.getInetAddress() + ":" + socket.getPort()+ ": "+ msg);

			//escrita no socket
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Oi cliente, mensagem recebida!");
			
			in.close();
			out.close();
			servidor.close();			
		}catch(Exception e){

		}
	}
	
}
