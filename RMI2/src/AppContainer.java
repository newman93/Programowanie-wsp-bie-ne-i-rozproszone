import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppContainer extends Remote {
  Object run(Plugin plugin) throws RemoteException;

}
