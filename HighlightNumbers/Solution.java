import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()))){
            
            String string = "";
            while(fileReader.ready()){
                String[] strArray = fileReader.readLine().split("\\s");
                for(String tmp : strArray){
                    int count = 0;
                    for(char character : tmp.toCharArray()){
                        if(character >= '0' && character <= '9'){
                            count ++;
                        }
                    }
                    if(count == tmp.length()){
                        string += tmp;
                    }else{
                        string += " ";
                    }
                }
            }
            //System.out.println(string);
            string = string.replaceAll("[ ]+"," ");
            fileWriter.write(string, 0, string.length());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

