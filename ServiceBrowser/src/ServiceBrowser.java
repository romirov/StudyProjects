package ServiceBrowser;
import java.awt.*;
import javax.swing.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.*;

/**
 * Клиентская часть ServiceBrowser
 * Он создает простое GUI и выполняет поиск по реестру RMI, чтобы получить заглушку ServiceServer
 * После этого он вызывает из нее удаленный метод, возвращающий набор сервисов, которые будут отображаться в раскрывающемся списке 
 */
 public class ServiceBrowser{
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public void buildGUI(){
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        Object[] services = getServicesList();//метод выполняет поиск по реестру RMI, получает заглушку и вызывает метод getServiceList()

        serviceList = new JComboBox(services);//добавляем сервисы(массив элементов Object) в виджет JComboBox

        frame.getContentPane().add(BorderLayout.NORTH, serviceList);

        serviceList.addActionListener(new MyListListener());
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    /* Здесь на панель добавляется настоящий сервис, после того как он будет выбран в списке
     Сам метод вызывается при событии, генерируемом JComboBox
     Мы вызываем getService из удаленного сервиса(заглушку для ServiceServer) и передаем ему строку, отображающуюся в списке
     Эта строка, которую мы получили при вызове метода getServiceList
     Сервер возвращает сериализованный объект сервиса, который благодаря RMI автоматически десериализуется, после чего мы вызываем из него метод getGuiPanel и добавляем полученный результат JPanel на главную панель обозревателя (mainPanel)*/
    void loadService(Object serviceSelection){
        try{
            Service svc = server.getService(serviceSelection);

            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        }catch(Exception ex){ ex.printStackTrace(); }
    }

    Object[] getServicesList(){
        Object obj = null;
        Object[] services = null;

        try{
           // obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");// ищем по реесту и получаем заглушку
           Registry registry = LocateRegistry.getRegistry("127.0.0.1");//"127.0.0.1");
        System.out.println(registry.list());

           server = (ServiceServer) registry.lookup("ServiceServer");
        }catch(Exception ex){ ex.printStackTrace(); }

        //server = (ServiceServer) obj;
        System.out.println("w");
        try{
            services = server.getServiceList();
        }catch(Exception ex){ ex.printStackTrace(); }
        System.out.println("wwwww");
        return services;
    }

    class MyListListener implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            Object selection = serviceList.getSelectedItem();
            loadService(selection);
        }
    }

    public static void main(String[] args){
        new ServiceBrowser().buildGUI();
    }
 }
