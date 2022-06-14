/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Jean Agreda
 */
public class UDPClient {

    public static void main(String[] args) throws SocketException, IOException {
//        DatagramSocket clientSocket = new DatagramSocket();
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        
//        InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
//        byte[] receiveData = new byte[1024];
//        byte[] sendData = new byte[1024];
//
//        System.out.println("Enviar datos al server");
//        String sentence = inFromUser.readLine();
//        sendData = sentence.getBytes();
//        
//        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 9876);
//        clientSocket.send(sendPacket);
//        
//        System.out.println("MESSASGE CLIENT SEND --");

        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.println("Enviar datos al server");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 9876);
        clientSocket.send(sendPacket);

        System.out.println("MESSASGE CLIENT SEND --");
        
        //Recive
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SRVER: "+ modifiedSentence);
        clientSocket.close();

    }
}
