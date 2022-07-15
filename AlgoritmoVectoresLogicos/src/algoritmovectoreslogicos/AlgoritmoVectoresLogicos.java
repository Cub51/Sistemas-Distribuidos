/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmovectoreslogicos;

/**
 *
 * @author Jean Agreda
 */
public class AlgoritmoVectoresLogicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //valores
        int pr1[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int pr2[][] = {{0, 0, 0}, {0, 0, 0}};
        int pr3[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        //Procesos
        String p1[] = {"a", "b", "c"};
        String p2[] = {"d", "e"};
        String p3[] = {"f", "g", "h"};

        //val iniciales
        int pp1 = 0;
        int pp2 = 0;
        int pp3 = 0;

        /*//uniones
        de |a| a |h|
        de |b| a |d|
        de |f| a |c|
        de |e| a |g|
         */
        if (pp1 == 0 && pr1[0][0] == 0) { //inciar valor a |a|
            pr1[0][0] = 1;
        }

        if (pp3 == 0 && pr3[0][2] == 0) { //iniciar valor a |f|
            pr3[0][2] = 1;
        }

        if (pr1[0][0] != 0) {//asignar valor a |b| 
            pr1[1][0] = pr1[0][0] + 1;
        }

        if (pr3[0][2] != 0) { //verificar que el valor a sido iniciado
            if (pr3[0][0] > pr1[1][0]) {// comparar que valor es mayor si el de |f| o el de |b|
                pr1[2][0] = pr3[0][0] + 1;//asignar valor a |c|
                pr1[2][2] = pr3[0][2]; //pasar el valor de f
            } else {
                pr1[2][0] = pr1[1][0] + 1;
                pr1[2][2] = pr3[0][2];//pasar el valor de f
            }
        }

        //asignar valor a |d|
        if (pp2 == 0 && pr2[0][1] == 0) { //iniciar valor a |f|
            pr2[0][1] = 1;
            pr2[0][0] = pr1[1][0];//valor de b
        }

        if (pr2[0][1] != 0) { //asignar valor a |e|
            pr2[1][1] = pr2[0][1] + 1;
            pr2[1][0] = pr1[1][0]; // pasar el valor de b
        }

        //asignar valor a |g|
        if (pr3[0][2] > pr2[1][2]) { // comparar que valor es mayor si el de |f| o el de |e|
            pr3[1][2] = pr3[0][2] + 1;
            pr3[1][0] = pr2[1][0]; // pasar el valor de b
            pr3[1][1] = pr2[1][1]; // pasar el valor de e
        } else {
            pr3[1][2] = pr2[1][2] + 1;
            pr3[1][0] = pr2[1][0]; // pasar el valor de b
            pr3[1][1] = pr2[1][1]; // pasar el valor de e
        }

        //asignar valor a |h|
        if (pr3[1][2] > pr1[0][2]) { // comparar que valor es mayor si el de |g| o el de |e|
            pr3[2][2] = pr3[1][2] + 1;
            pr3[2][1] = pr3[1][1]; // pasar el valor de e
            pr3[2][0] = pr3[1][0]; // pasar el valor de b
        } else {
            pr3[2][2] = pr1[0][2] + 1;
            pr3[2][1] = pr3[1][1];
            pr3[2][0] = pr3[1][0];
        }

//presentar
        System.out.print("Proceso 1:==>");
        for (int j = 0; j < 3; j++) {
            System.out.print(" | " + p1[j]+" :");
            for (int i = 0; i < p1.length; i++) {
                System.out.print("- " + pr1[j][i] + " ");
            }
        }
        System.out.println("\n");
        System.out.print("Proceso 2:==>\t\t\t");
        for (int j = 0; j < 2; j++) {
            System.out.print(" | " + p2[j]+" :");
            for (int i = 0; i < 3; i++) {
                System.out.print("- " + pr2[j][i] + " ");
            }
        }
        System.out.println("\n");
        System.out.print("Proceso 3:==>");
        for (int j = 0; j < 3; j++) {
            System.out.print(" | " + p3[j]+" :");
            for (int i = 0; i < p3.length; i++) {
                System.out.print("- " + pr3[j][i] + " ");
            }
        }
        System.out.println("");

    }

}
