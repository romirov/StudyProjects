import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try{
            if(!args[0].isEmpty()){
                
                try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))){
                    while(fileReader.ready()){
                        String fio = "";
                        String[] stringFromFile = fileReader.readLine().split(" ");
                        //get fio
                        for(String str : stringFromFile){
                            if(!str.matches("\\p{Digit}+"))
                                fio += str + " ";
                        }
                        fio = fio.substring(0, fio.length() - 1);

                        //get date
                        int day = Integer.parseInt(stringFromFile[stringFromFile.length - 3]);
                        int month = Integer.parseInt(stringFromFile[stringFromFile.length - 2]) - 1;
                        int year = Integer.parseInt(stringFromFile[stringFromFile.length - 1]);
                        
                        Calendar calendar = new GregorianCalendar(year, month, day);
                        PEOPLE.add(new Person(fio, calendar.getTime()));
                    }
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
            //test
            //for(Person person : PEOPLE)
            //    System.out.println(person.getName() + " " + person.getBirthDate());
        }catch(ArrayIndexOutOfBoundsException aioobe){
            aioobe.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
}

