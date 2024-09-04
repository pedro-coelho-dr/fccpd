package examples.multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class ClientMulticast {
   public static void main(String[] args) throws IOException {	   
	      
	      String msg = " ";	      
	      MulticastSocket socket=new MulticastSocket(4321);
	      
	      InetAddress ia =InetAddress.getByName("230.0.0.0");
	      InetSocketAddress grupo = new InetSocketAddress(ia , 4321);
	      NetworkInterface ni = NetworkInterface.getByInetAddress(ia);
	      
	      socket.joinGroup(grupo,ni);
	      
	      while(!msg.contains("Servidor Encerrado!")){
	         System.out.println("[Cliente] Esperando por mensagem Multicast...");
	         byte[] buffer = new byte[1024];
	         
	         DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
	         socket.receive(packet);
	         
	         msg=new String(packet.getData());
	         System.out.println("[Cliente] Mensagem recebida do Servidor: "+msg);
	       
	      }

          System.out.println("[Cliente] Conexao Encerrada!");
	      socket.leaveGroup(grupo, ni);
	      socket.close();
	   
   }

  
}