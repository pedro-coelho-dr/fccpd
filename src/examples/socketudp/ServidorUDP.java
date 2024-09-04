package examples.socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
	public static void main(String[] args) {
	  int encerrar = 0;
	  
	  try {
		 DatagramSocket servidorSocket = new DatagramSocket(6700);
		 System.out.println("\n[SERVIDOR]: Ativo!");
		
		 while(encerrar == 0){
			    byte[] envia = new byte[1024];
			    byte[] recebe = new byte[1024];
			    
			    //Recebe do cliente				
			    DatagramPacket recebePacote = new DatagramPacket(recebe,recebe.length);
				servidorSocket.receive(recebePacote);			
				String mensagem = new String(recebePacote.getData());
				System.out.println("[SERVIDOR]: Recebido do Cliente: "+ mensagem);							
				
				//tratando a opção do menu
				String resultado = null;
				String[] tratada = mensagem.split(":", 2);				
				switch (tratada[0].trim()) {
				case "1":
					String[] valor = tratada[1].split("\\-",2);					
					int subt = Integer.parseInt(valor[0].trim()) -(Integer.parseInt(valor[1].trim()));
					resultado = "Resultado Subtracao:" +Integer.toString(subt);
					break;
				case "2":
					String[] valor2 = tratada[1].split("\\+",2);					
					int soma = Integer.parseInt(valor2[0].trim()) +(Integer.parseInt(valor2[1].trim()));
					resultado = "Resultado Soma:" +Integer.toString(soma);
					break;
				case "3":
					System.out.println("[SERVIDOR] Fechando as conexoes");
					resultado = "Conexao Fechada";
					encerrar = 1;
					break;
				default:
					resultado = new String("\nOpcoes do MENU:\n1-Subtracao(1:5-3), \n2-Soma(2:7+4); \n3-fechar o servidor");
					break;
				}
				
				//enviando para o cliente				
				envia = resultado.getBytes();
				DatagramPacket enviaPacote = new DatagramPacket(envia, envia.length, recebePacote.getAddress(),recebePacote.getPort());
				servidorSocket.send(enviaPacote);
								
			}	
		 	//encerrando o servidor
			System.out.println("[SERVIDOR]: Conexao Encerrada!");
			servidorSocket.close();
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

	}

}
