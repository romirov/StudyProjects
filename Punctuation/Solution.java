import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.
*/

public class Solution {
    public static void main(String[] args) {
        
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(reader.readLine()))){

            while(fReader.ready()){
                String[] strings = fReader.readLine().split("[\\p{Punct}]+");
                for(String str : strings){
                    fWriter.write(str, 0, str.length());
                }
            }

        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}

