
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;



/* 
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.
Требования:
Поле pattern должно быть отмечено модификатором transient.
Поле currentDate должно быть отмечено модификатором transient.
Поле temperature должно быть отмечено модификатором transient.
Поле string НЕ должно быть отмечено модификатором transient.
*/

public class Solution implements Serializable{
    public static void main(String[] args) {
        File file = new File("test");
        try(FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file)){
            Solution savedObject = new Solution(4);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(savedObject);

            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Solution loadedObject = (Solution) ois.readObject();

            if(loadedObject.toString().equals(savedObject.toString())){
                System.out.println("Loaded Object equals Saved Object");
            }
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
