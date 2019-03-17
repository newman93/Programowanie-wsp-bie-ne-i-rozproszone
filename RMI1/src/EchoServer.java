
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class EchoServer extends UnicastRemoteObject implements Echo{
  
  public EchoServer() throws RemoteException {
    
  }
  
  @Override
  public String reply(String s) {
    System.out.println("EchoServer: oderbana wiadomość: "+s);
    
    return s;
  }
  
  public static void main(String[] args) {
     System.setSecurityManager(new RMISecurityManager());
     
     String name = args[0];
     try {
      EchoServer server = new EchoServer();
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind(name, server);
     System.out.println("EchoServer zarejestrował się");
     } catch(Exception e) {
       System.err.println("EchoServer wyjątek: "+e.getMessage());
       e.printStackTrace();
     } 
  }
}
