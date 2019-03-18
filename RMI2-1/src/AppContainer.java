import java.rmi.Remote;
import java.rmi.RemoteException;

interface AppContainer extends Remote {
  Object run(Plugin plugin) throws RemoteException;
}
