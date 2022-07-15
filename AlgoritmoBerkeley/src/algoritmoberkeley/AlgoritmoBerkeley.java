/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoberkeley;

import javax.swing.JOptionPane;

/**
 *
 * @author Jean Agreda
 */
public class AlgoritmoBerkeley {

    /**
     * @param args SIMULACION DEL ALGORITMO DE BERKELEY
     */
    public static void main(String[] args) {
        //  Datos quemados
        boolean verf = true;
        int intervalo = 3;
        int ut = 4; //unidades de tiempo de variacion
        int s = 10000; //servidor 10 000
        int c1 = 9998; //cliente 9998
        int c2 = 10001; //cliente 10001
        int c3 = 10005; //cliente 10005

        int t0 = 0;
        //t0 = s;

        int d1 = 0;
        int d2 = 0;
        int d3 = 0;

        int d = 0;

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        while (verf) { //iniciar valores            
            try {
                s = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del Servidor |s| : "));
                c1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del Cliente 1 |c1| : "));
                c2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del Cliente 2 |c2| : "));
                c3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del Cliente 3 |c3| : "));
                t0 = s;

                verf = false;
            } catch (Exception e) {
                System.out.println("Err: " + e);
                JOptionPane.showMessageDialog(null, "Cadena ingresada, debe ingresar un valor numerico", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        for (int i = 0; i < intervalo; i++) {
            int Tli = 0;

            c1 = c1 + ut;
            c2 = c2 + ut;
            c3 = c3 + ut;
            s = s + ut;

            if (i == 0) { //diferencia de tiempo C - S
                d1 = c1 - t0;
                d2 = c2 - t0;
                d3 = c3 - t0;
                System.out.println(" ****************************");
                System.out.println(" * d1: " + d1 + " d2: " + d2 + " d3: " + d3);
                System.out.println(" ****************************\n");
            }

            if (i == 1) { //diferencia de tiempo C - S
                Tli = s;
                d1 = d1 - (Tli - t0) / 2; // d1' prima
                d2 = d2 - (Tli - t0) / 2; // d2' prima
                d3 = d3 - (Tli - t0) / 2; // d3' prima
                d = (d1 + d2 + d3 + 0) / 4;

                s = s + d;
                System.out.println(" ********************");
                System.out.println(" * d1': " + d1 + " d2': " + d2 + "d3': " + d3);
                System.out.println(" * D: " + d);
                System.out.println(" * Nuevo tiempo del Servidor: " + s);
                System.out.println(" ********************\n");
            }

            if (i == 2) {
                a1 = d - d1;
                a2 = d - d2;
                a3 = d - d3;
                System.out.println(" ********************");
                System.out.println(" * A1: " + a1 + " A2: " + a2 + "A3: " + a3);
                System.out.println(" ********************\n");
                
                c1 = c1 + a1;
                c2 = c2 + a2;
                c3 = c3 + a3;
            }

            System.out.println("S: " + s + " | C1: " + c1 + " | C2: " + c2 + " | C3: " + c3+"\n");

        }

    }

}
