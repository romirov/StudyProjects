import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> emploees = new TreeMap<>();
        try{
            if(!args[0].isEmpty()){
                try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
                    while(reader.ready()){
                        String[] data = reader.readLine().split(" ");

                        if(emploees.containsKey(data[0])){
                            double salary = emploees.get(data[0]);
                            emploees.put(data[0], salary + Double.parseDouble(data[1]));
                        }else{
                            emploees.put(data[0], Double.parseDouble(data[1]));
                        }
                    }
                    TreeSet<Double> salaries = new TreeSet<>();
                    salaries.addAll(emploees.values());
                    double highestSalary = salaries.last();
                    for(Map.Entry<String, Double> emploee : emploees.entrySet()){
                        if(emploee.getValue() == highestSalary){
                            System.out.println(emploee.getKey());
                        }
                    }
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            aioobe.printStackTrace();
        }
    }
}

