/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Jean Agreda
 */
public class UDPServer {

    public static void main(String[] args) throws SocketException, IOException {

//        byte[] receiveData = new byte[1024];
//        byte[] sendData = new byte[1024];
//
//        DatagramSocket serverSocket = new DatagramSocket(9876);
//
//        while (true) {
//            System.out.println("Server Active -");
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            serverSocket.receive(receivePacket);
//            
//            String sentence = new String(receivePacket.getData());
//            System.out.println("Message: "+sentence);
//            System.out.println("Server Active --");
//            
//        }  

   DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        DatagramSocket serverSocket = new DatagramSocket(9876);

        while (true) {
            System.out.println("Server Active -");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData());
            
            
          
            
            
            // Enviar MSJ
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            String capitalizeSentene = sentence.toUpperCase();
            sendData = capitalizeSentene.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port);
            serverSocket.send(sendPacket);
            
      
             System.out.println("Message: " + sentence);
            System.out.println("Server OUT");
            
             

        }
    }
}
