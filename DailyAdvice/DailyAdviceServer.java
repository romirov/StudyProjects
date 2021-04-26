package DailyAdvice;
import java.io.*;
import java.net.*;

/**
 *  Эта программа создает ServerSocket и ожидает клиентских заросов
 *  При получении запроса программа создает объект Socket и устанавливает соединение с этим клиентом
 *  Сервер создает объект PrintWrite и отправляет клиенту сообщение
 */

public class DailyAdviceServer{
  String[] adviceList = {
  "Ешьте меньшими порциями", "Больше пейте", "Возможно стоит постричься"
  };

  public void go(){
    try{
      //Приложение отслеживает клиентские запросы на порту 4242 при помощи ServerSocket
      ServerSocket serverSock = new ServerSocket(4242);
    
      //Сервер входит в постоянный цикл, ожидая клиентских подключений
      while(true){
        //метод accept блокирует приложение до тех пор, пока не потсупит запрос,
        //после чего возвращает сокет на анонимном порту для взаимодействия с клиентом
        Socket sock = serverSock.accept();

        PrintWriter writer = new PrintWriter(sock.getOutputStream());

        String advice = getAdvice();
        writer.println(advice);
        writer.close();
        System.out.println(advice);
      }
    }catch(IOException ex){
      ex.printStackTrace();
    }
  }

  private String getAdvice(){
    int random = (int) (Math.random() * adviceList.length);
    return adviceList[random];
  }

  public static void main(String[] args){
    DailyAdviceServer server = new DailyAdviceServer();
    server.go();
  }
}
