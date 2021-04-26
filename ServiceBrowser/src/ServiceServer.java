package ServiceBrowser;
import java.rmi.*;
/**
 * Интерфейс ServiceServer унаследован от удаленного интерфейса
 * Он содержит методы для получения списка сервисов и выбора одного из них
 */
public interface ServiceServer extends Remote{
    Object[] getServiceList() throws RemoteException;
    Service getService(Object serviceKey) throws RemoteException;
}
