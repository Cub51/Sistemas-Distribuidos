import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class Cliente {

    public static void main(String[] args) throws SocketException, IOException {
    	int cont = 0;
        MulticastSocket clienteSocket = new MulticastSocket();
        byte[] sendData = new byte[1024];
        System.out.println("El cliente esta activo");
        while (true) {

        	cont = cont + 1 ;
            System.out.println("Mensaje Cliente: "+cont);
            String mensaje = "Mensaje: "+cont;
            sendData = mensaje.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("230.0.0.1"), 5000);
            clienteSocket.send(sendPacket);
        }

    }

}