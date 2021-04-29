import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
            //List<String> data = new ArrayList<>();
            while(fileReader.ready()){
                String str = fileReader.readLine();
                String[] strings = str.split("\\s"); 
                int count = 0;
                

                for(String tmp : strings){
                    for(String word : words){
                        if(tmp.equals(word)) count++;
                    }
                }
                if(count == 2)
                    System.out.println(str);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

