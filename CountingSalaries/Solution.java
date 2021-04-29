import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> employees = new TreeMap<>();
        try{
        if(!args[0].isEmpty()){
            try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
                while(reader.ready()){
                    String[] data = reader.readLine().split(" ");
                    if(employees.containsKey(data[0])){
                        double salary = employees.get(data[0]);
                        employees.put(data[0], salary + Double.parseDouble(data[1]));
                    }else{
                        employees.put(data[0], Double.parseDouble(data[1]));
                    }
                }

                for(Map.Entry<String, Double> employee : employees.entrySet()){
                    System.out.println(employee.getKey() + " " + employee.getValue());
                }
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            System.out.println("Error: Enter file name");
        }
    }
}

