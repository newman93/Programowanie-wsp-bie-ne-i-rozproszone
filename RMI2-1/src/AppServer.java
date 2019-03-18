import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AppServer extends UnicastRemoteObject implements AppContainer {

  public AppServer () throws RemoteException {
    super();
  }
  @Override
  public Object run(Plugin plugin) throws RemoteException {
    return plugin.compute();
  }
  
  public static void main(String[] args) {
    System.setSecurityManager(new SecurityManager());
    try {
      String name = args[0];
      AppServer server = new AppServer();
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind(name,server);
      System.out.println("Serwer zarejestrował się!");
    } catch (Exception e) {
      System.err.println("AppServer exception: "+e.getMessage());
      e.printStackTrace();
    }
  }  
}
