import java.rmi.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl implements MyRemote{
    public String sayHello(){
        return "Server say: Hi";
    }

    public MyRemoteImpl() throws RemoteException{}

    public static void main(String[] args){
        try{
            MyRemoteImpl ser = new MyRemoteImpl();
            MyRemote service = (MyRemote) UnicastRemoteObject.exportObject(ser, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Hello", service);
            System.err.println("Server ready");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
