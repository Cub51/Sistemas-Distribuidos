import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class Servidor {

    public static void main(String[] args) throws SocketException, IOException {
        MulticastSocket serverSocket = new MulticastSocket(5000);
        serverSocket.joinGroup(InetAddress.getByName("230.0.0.1"));
        byte[] recData = new byte[1024];
        System.out.println("SERVIDOR EN LINEA");
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(recData, recData.length);
            serverSocket.receive(receivePacket);
            String mensaje = new String(receivePacket.getData());
            System.out.println(mensaje);
        }

    }

}
