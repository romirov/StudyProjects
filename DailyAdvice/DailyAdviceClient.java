package DailyAdvice;
import java.io.*;
import java.net.*;

/**
 * Простейший клиент, который считывает по сети сообщения с сервера
 */

public class DailyAdviceClient{
  public void go(){
    try{
      /*создаем соединение через сокет к приложению, работающему на порту 4242*/
      Socket s = new Socket("127.0.0.1", 4242);

      InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
      BufferedReader reader = new BufferedReader(streamReader);//подключаем BufferedReader к InputStreamReader

      String advice = reader.readLine();
      System.out.println("Сегодня ты должен: " + advice);
      
      reader.close();
    }catch(IOException ex){
      ex.printStackTrace();
    }
  }

  public static void main(String[] args){
    DailyAdviceClient client = new DailyAdviceClient();
    client.go();
  }
}
