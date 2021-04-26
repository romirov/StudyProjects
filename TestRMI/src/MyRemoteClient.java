import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient{
    public static void main(String[] args){
        new MyRemoteClient().go();
    }

    public void go(){
        try{
            String host = "127.0.0.1";
            Registry registry = LocateRegistry.getRegistry(host);
            MyRemote service = (MyRemote) registry.lookup("Hello");

            String s = service.sayHello();

            System.out.println("Response:" + s);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
