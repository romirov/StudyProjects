import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
/* 
Перевертыши
1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
            String result = "";
            while(fileReader.ready()){
                result += new StringBuilder(fileReader.readLine()).reverse().toString() + '\n';
            }
            System.out.print(result);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

