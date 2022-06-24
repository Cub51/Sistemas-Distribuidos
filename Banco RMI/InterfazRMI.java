import java.rmi.Remote;
import java.rmi.RemoteException;
// Jean Agreda

public interface InterfazRMI extends Remote{
    public double depositar(double montoTransaccion, double saldo)throws RemoteException;

    public double retirar(double montoTransaccion, double saldo)throws RemoteException;    
}
