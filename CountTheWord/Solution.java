import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово:
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fReader = new FileReader(reader.readLine())){
            
            String str = "";

            while(fReader.ready()){
                char[] charArray = new char[1000];
                int lengthDataInCharArray = fReader.read(charArray);
                str += new String(charArray, 0, lengthDataInCharArray);
            }
            String[] words = str.split("[\\p{Punct}\\s]+");
            int count = 0;
            for(String tmp : words){
                if(tmp.equals("world"))
                    count++;
            }
            System.out.println(count);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

