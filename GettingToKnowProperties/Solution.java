import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Properties;


/* 
Знакомство с properties
Метод main() считывает имя файла с консоли и заполняет runtimeStorage данными из файла.
В методах save() и load() реализуй логику записи в файл и чтения из файла для карты runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле можно игнорировать.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Требования:
•	Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
•	Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream,"");

    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.load(inputStream);
       for (Map.Entry<Object,Object> pair : properties.entrySet()){
           runtimeStorage.put(pair.getKey().toString(), pair.getValue().toString());
       }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
            try{
                save(new FileOutputStream("out"));
            } catch (Exception e) {
              e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
