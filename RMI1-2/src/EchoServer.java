
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer implements Echo {
  
  @Override
  public String reply(String s) throws RemoteException {
    System.out.println("EchoServer: odpowiedź: "+s);
    return s;
  }
  
  public static void main(String[] args) {
    System.setSecurityManager(new RMISecurityManager());
    
    try{
      String name = args[0];
      EchoServer server = new EchoServer();
      Echo stub = (Echo) UnicastRemoteObject.exportObject(server, 0);
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind(name, stub);
      System.out.println("EchoServer zarejestrował się");
    } catch(Exception e) {
      System.err.println("EchoServer erro: "+e.getMessage());
      e.printStackTrace();
    }
  }
  
}
