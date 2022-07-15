/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.algoritmocristian;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jean Agreda
 */
public class Cliente {

    private static int puerto = 5050;
    private static String hostName = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        long t0; // tiempo cliente
        long t1; // tiempo cliente
        long cs; //tiempo del servidor
        long c; //resultado
        DateFormat df = new SimpleDateFormat("hh:mm:ss:sssss");

        try {

            Socket socketCliente = new Socket(hostName, puerto);
            ObjectOutputStream salida = new ObjectOutputStream(socketCliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socketCliente.getInputStream());

            System.out.println("NODO CLIENTE INICIADO");

            //cliente adelantado con 5 seg referente al servidor
            
            t0 = System.currentTimeMillis();
            salida.writeLong(t0);
            cs = (entrada.readLong());
            t1 = System.currentTimeMillis()+ 10000;
            
            //cliente retrasado con 5 seg referente al servidor
            /*
            t0 = System.currentTimeMillis() - 1000;
            salida.writeLong(t0);
            cs = (entrada.readLong());
            t1 = System.currentTimeMillis() + 9000;
            */
            c = (cs + (t1 - t0) / 2);//formula

            System.out.println(" T0 - del Cliente: " + df.format(new Date(t0)));
            System.out.println(" CS - del Servidor: " + df.format(new Date(cs)));            
            System.out.println(" T1 - del Cliente: " + df.format(new Date(t1)));

            System.out.println("********************************************************");
            System.out.println("Actualización del tiempo en el nodo cliente\nT1 - Nuevo tiempo del cliente: " + df.format(new Date(c)));

            //entrada.close();
            //socketCliente.close();
        } catch (Exception e) {
            System.out.println("err : " + e);
        }
    }

}
