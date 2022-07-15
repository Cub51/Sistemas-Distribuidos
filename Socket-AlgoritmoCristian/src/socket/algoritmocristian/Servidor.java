/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.algoritmocristian;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jean Agreda
 */
public class Servidor {

    private static int port = 5050;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            server = new ServerSocket(port);
            //long tiempoActual = System.currentTimeMillis();

            System.out.println("SERVIDOR EN LINEA");
            Socket socket = server.accept();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                oos.writeLong(System.currentTimeMillis());//tiempo del servidor
                System.out.println("MSJ: " + oos);
                oos.close();
                socket.close();
            }

          
        } catch (Exception e) {
            System.out.println("err : " + e);
        }

    }

}
