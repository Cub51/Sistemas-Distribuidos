/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Jean Agreda
 */
public class Cliente {

    private static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("iniciando el socket para comunicarnos ");
        Socket socket = new Socket(host, port);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("Mi primera vez");
        System.out.println(String.valueOf(oos));
        // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        //String mensaje = String.valueOf(ois.readObject());
        //oos.close();
       // socket.close();
        

    }

}
