import java.rmi.Naming;
// Jean Agreda

public class Servidor {
    public Servidor(){
        try {
            System.out.println("Servidor en Linea");
            InterfazRMI objD = new ImplementationRMI();
            Naming.rebind("rmi://localhost/BANCO", objD);
        } catch (Exception e) {
            System.out.println("ERROR-SERVIDOR: " + e);
        }
    }
    public static void main(String [] args){
        new Servidor();
    }
}
