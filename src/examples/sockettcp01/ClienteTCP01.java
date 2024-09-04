package examples.sockettcp01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClienteTCP01 {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("127.0.0.1", 6700);
			
			//escrita no socket
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF("Oi servidor");
			
			//leitura do socket
			DataInputStream in = new DataInputStream(s.getInputStream());
			System.out.println("[CLIENTE] Recebi do Servidor: "+ in.readUTF());

			in.close();
			out.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
