
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AppClient {
  public static void main(String[] args) {
    System.setSecurityManager(new SecurityManager());
    
    try {
      String host = args[0];
      String name = args[1];
      int number = Integer.parseInt(args[2]);
      FibPlugin fib = new FibPlugin(number);
      Registry registry = LocateRegistry.getRegistry(host);
      AppContainer container = (AppContainer) registry.lookup(name);
      System.out.println(container.run(fib));    
    } catch (Exception e) {
      System.err.println("AppClient exception: "+e.getMessage());
      e.printStackTrace();
    }
  }
}
