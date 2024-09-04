package examples.socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {

	public static void main(String[] args) {
		
		byte[] recebe = new byte[1024];		
		try {
			DatagramSocket clienteSocket = new DatagramSocket();
			
			System.out.println("Opcoes do MENU:\n1-Subtracao(1:5-3), \n2-Soma(2:7+4); \n3-fechar o servidor");
			Scanner sc= new Scanner(System.in);
			String envia = sc.nextLine();
			
			//envia ao servidor
			DatagramPacket enviaPacote = new DatagramPacket(envia.getBytes(),envia.length(), InetAddress.getByName("127.0.0.1"), 6700);
			clienteSocket.send(enviaPacote);
		
			//recebe do servidor
			DatagramPacket recebePacote = new DatagramPacket(recebe,recebe.length);
			clienteSocket.receive(recebePacote);
			String mensagemRecebida = new String(recebePacote.getData());
			System.out.println("[CLIENTE]: Recebi do Servidor: " + mensagemRecebida);	
			
			clienteSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
