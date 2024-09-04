package examples.sockettcp02;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

	public static void main(String[] args) throws IOException {
		//criando a conexão
		Socket socket = new Socket("127.0.0.1", 6700);
		System.out.println("[CLIENTE]: conectado ao Servidor!");
		
		//Objeto de escrita
		ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
		
		String assunto = "";
		String mensagem = "";
		Scanner sc= new Scanner(System.in);  
		
		do{			
			System.out.print("Escreva o Assunto: ");  
			assunto= sc.nextLine();
			System.out.print("Escreva a Mensagem: ");  
			mensagem= sc.nextLine();
			Mensagem m1 = new Mensagem(assunto, mensagem);
			
			//escrever a mensagem no output
			saida.writeObject(m1);
			saida.flush();
		}while(!assunto.equals("FIM"));

		//encerrando a conexão
		saida.close();
		socket.close();
	}

}