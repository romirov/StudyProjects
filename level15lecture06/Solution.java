import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        //напишите тут ваш код
        //URLConnection connection = url.openConnection();
        // читаем данные
        try(InputStream input = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input)))
        {
            while (reader.ready())
            System.out.println(reader.readLine());
        }
    }
}
