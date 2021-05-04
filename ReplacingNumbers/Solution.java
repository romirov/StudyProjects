import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
        
    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
            while(fileReader.ready()){
                String[] wordsInString = fileReader.readLine().split(" ");
                
                String result = "";
                for(String str : wordsInString){
                    if(str.matches("\\p{Digit}\\p{Punct}*|\\p{Digit}[0-2]\\p{Punct}*")){
                            char[] symbols = str.toCharArray();
                            String tmp = "";
                            for(int i = 0 ; i < symbols.length; i++){
                                if(symbols[i] >= (int)'0' && symbols[i] <= (int)'9'){
                                    tmp += symbols[i];
                                }else{
                                    if(tmp.length()>0){
                                        int num = Integer.parseInt(tmp);
                                        result += map.get(num);
                                    }
                                    tmp = "";
                                    result += symbols[i];
                                }
                            }
                            if(tmp.length()>0){
                                int num = Integer.parseInt(tmp);
                                result += map.get(num);
                            }
                            result += " ";
                    }else{
                        result += str + " ";
                    }
                }
                System.out.println(result.substring(0, result.length() - 1));
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

