/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmolamport;

/**
 *
 * @author Jean Agreda
 */
public class AlgoritmoLamport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //valores
        int pr1[] = {0, 0, 0};
        int pr2[] = {0, 0};
        int pr3[] = {0, 0, 0};
        int global[] = {0, 0, 0, 0, 0, 0, 0, 0};
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
        if (pp1 == 0 && pr1[0] == 0) { //inciar valor a |a|
            pr1[0] = 1;
            pp1 = 1;
        }

        if (pp3 == 0 && pr3[0] == 0) { //iniciar valor a |f|
            pr3[0] = 1;
            pp3 = 1;
        }

        if (pr1[0] != 0) {//asignar valor a |b| en 2
            pr1[1] = pr1[0] + 1;
        }

        if (pr3[0] != 0) { //verificar que el valor a sido iniciado
            if (pr3[0] > pr1[1]) {// comparar que valor es mayor si el de |f| o el de |b|
                pr1[2] = pr3[0] + 1;//asignar valor a |c|
            } else {
                pr1[2] = pr1[1] + 1;
            }
        }

        //asignar valor a |d|
        if (pp2 > pr1[1]) { // comparar que valor es mayor si el de |p2 inicial| o el de |b|
            pr2[0] = pp2 + 1;
        } else {
            pr2[0] = pr1[1] + 1;
        }

        if (pr2[0] != 0) { //asignar valor a |e|
            pr2[1] = pr2[0] + 1;
        }

        //asignar valor a |g|
        if (pr3[0] > pr2[1]) { // comparar que valor es mayor si el de |f| o el de |e|
            pr3[1] = pr3[0] + 1;
        } else {
            pr3[1] = pr2[1] + 1;
        }

        //asignar valor a |h|
        if (pr3[1] > pr1[0]) { // comparar que valor es mayor si el de |g| o el de |e|
            pr3[2] = pr3[1] + 1;
        } else {
            pr3[2] = pr1[0] + 1;
        }
//presentar
        System.out.print("Proceso 1:==>");
        for (int i = 0; i < p1.length; i++) {
            System.out.print(" - " + p1[i] + " : " + pr1[i] + "\t");
        }
        System.out.println("\n");
        System.out.print("Proceso 2:==>\t\t");
        for (int i = 0; i < p2.length; i++) {
            System.out.print(" - " + p2[i] + " : " + pr2[i] + "\t");
        }
        System.out.println("\n");
        System.out.print("Proceso 3:==>");
        for (int i = 0; i < p3.length; i++) {
            System.out.print(" - " + p3[i] + " : " + pr3[i] + "\t");
        }
        System.out.println("\n\nListado de procesos");
        pp1 = 1;
        pp2 = 2;
        pp3 = 3;

        for (int i = 0; i < p1.length; i++) {
            pr1[i] = (pr1[i] * 10) + pp1;
        }
        for (int i = 0; i < p2.length; i++) {
            pr2[i] = (pr2[i] * 10) + pp2;
        }
        for (int i = 0; i < p3.length; i++) {
            pr3[i] = (pr3[i] * 10) + pp3;
        }
        //Ingresar todos los valoress dentro de un mismo arreglo
        int l = 0;
        int j = 0;
        int k = 0;
        for (int i = 0; i < global.length; i++) {
            if (i < 3) {
                global[i] = pr1[l];
                l++;
            }
            if (i > 2 && i < 5) {
                global[i] = pr2[k];
                k++;
            }
            if (i > 4 && i < 8) {
                global[i] = pr3[j];
                j++;
            }

            System.out.print(" | " + global[i]);
        }
        System.out.println("");
        int aux =0;
        for (int i = 0; i < global.length; i++) {
            for (int m = 0; m < global.length -1; m++) {
                if (global[m] > global[m+1]) {
                    aux =global[m];
                    global[m]= global[m+1];
                    global[m+1] = aux;
                }
            }
        }
        
        System.out.println("\nListado de procesos ordenado");
        for (int i = 0; i < global.length; i++) {
            System.out.print(" | "+global[i]);   
        }
        System.out.println("");

    }

}
