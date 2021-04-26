package ServiceBrowser;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * Серверная часть ServiceBrowser
 * Настоящий удаленный RMI-сервис(наследует UnicastRemoteObject)
 * Его задача - создать экземпляры всех сервисов(сущностей, которые будут передаваться клиенту) и хранить их
 * Он также должен внести себя в реестр RMI
 */

public class ServiceServerImpl implements ServiceServer{
    
    /**
     * Сервисы будут храниться в коллекции HashMap
     * Всесто одного объекта мы добавляем в коллекцию сразу два - ключ(строку) и значение(любой объект)
    */
    HashMap serviceList;

    /* При вызове конструктора инициализируем сервисы DiceService, MiniMusicService и DayOfTheWeekService */
    public ServiceServerImpl() throws RemoteException{
        setUpServices();
    }

    private void setUpServices(){
        serviceList = new HashMap();
        /* Создаем сервисы(их настоящие объекты и помещаем их в HashMap вместе со строковым именем-ключем) */
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    /* этот метод вызывается, чтобы получить список сервисов и отобразить их в обозревателе для выбора одного из сервисов*/
    public Object[] getServiceList() throws RemoteException{
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    /* этот метод вызывается после того, как пользователь выберет сервис в раскрывающимся списке(список сервисов получаем, используя метод выше)*/
    public Service getService(Object serviceKey) throws RemoteException{
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }
    public static void main(String[] args){
        try{
            //Naming.rebind("ServiceServer", new ServiceServerImpl());
           ServiceServerImpl myServiceServerImpl = new ServiceServerImpl();
           ServiceServer myServiceServer = (ServiceServer) UnicastRemoteObject.exportObject(myServiceServerImpl, 0);
           Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
           registry.bind("ServiceServer", myServiceServer);
            System.err.println("Remote service is running:"+ registry.list());
        } catch(Exception ex){ ex.printStackTrace(); }
        System.out.println("Remote service is running");
    }
}
