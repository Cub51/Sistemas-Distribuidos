import java.rmi.Naming;
import java.io.*;
import java.util.Scanner;
// Jean Agreda

public class Cliente{
    
    public static void main(String [] args){
        boolean exit = false;
        String nombre = "Jean Agreda";
        double montoTrans; // Monto de la transaccion DEPOSITO O RETIRO
        double saldo = 500;
        Scanner dinero_D_R;
        Scanner op; //OPCIONES 
        try {
            InterfazRMI interfaz = (InterfazRMI)Naming.lookup("rmi://localhost/BANCO");
            System.out.println("¡ Bienvenido Sr. " + nombre +" !");
            do {
                System.out.println("Posee un sado de | $" + saldo + " | en su cuenta bancaria.");
                System.out.println("Escoja la opción a realizar");
                System.out.println("1. DEPOSITAR");
                System.out.println("2. RETIRAR");
                System.out.println("3. EXIT");
                op  = new Scanner(new InputStreamReader(System.in));
                switch (op. next()) {
                    case "1":
                        System.out.println("Deposito");
                        System.out.println("Ingrese el monto a depositar: ");
                        dinero_D_R = new Scanner(new InputStreamReader(System.in));
                        montoTrans = Double.parseDouble(dinero_D_R.next());
                        while (montoTrans <= 0) {
                            System.out.println("Valor de depósito ingresado no válido\n"+
                                "Ingrese valores positivos mayores a -0- , ingrese una nueva cantidad: ");
                            dinero_D_R = new Scanner(new InputStreamReader(System.in));
                            montoTrans = Double.parseDouble(dinero_D_R.next());
                        }
                        saldo = interfaz.depositar(montoTrans, saldo);
                        System.out.println("¡ Depósito realizado con éxito !\n\n El saldo en su cuenta es de: $" + saldo+"\n\n\n");
                        break;

                    case "2":
                        System.out.println("Retiro");
                        System.out.println("Ingrese el monto a retirar: ");
                        dinero_D_R = new Scanner(new InputStreamReader(System.in));
                        montoTrans = Double.parseDouble(dinero_D_R.next());
                        while (montoTrans <= 0 || montoTrans > saldo) {
                             System.out.println("Valor de retiro ingresado no válido\n"+
                                "Ingrese valores positivos mayores a -0- y menores a su saldo actual, ingrese una nueva cantidad: ");
                            dinero_D_R = new Scanner(new InputStreamReader(System.in));
                            montoTrans = Double.parseDouble(dinero_D_R.next());
                        }
                        saldo = interfaz.retirar(montoTrans, saldo);
                        System.out.println("¡ Retiro realizado con éxito !\n\n El saldo en su cuenta es de: $" + saldo+"\n\n\n");

                        break;
                    case "3":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida\nIntente nuevamente por favor");
                        break;
                }
            } while (!exit);
            
        } catch (Exception e) {
            System.out.println("ERROR-CLIENTE: "+e);
        }
    }
}
