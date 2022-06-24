import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
// Jean Agreda

public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementationRMI() throws RemoteException{
        super();
    }

    // @Override
    public double depositar(double montoTransaccion, double saldo) throws RemoteException{
        saldo += montoTransaccion;
        return saldo;
    }
    
    // @Override
    public double retirar(double montoTransaccion, double saldo) throws RemoteException{
        saldo -= montoTransaccion;
        return saldo;
    }
}
