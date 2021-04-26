import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        InputStreamReader isr =  new InputStreamReader(System.in); 
        BufferedReader bf = new BufferedReader(isr);
        String str = "";
        while((str = bf.readLine()) != null){
            if(str.equals("exit")) break;
            if(str.matches("[0-9]+\\.[0-9]+")){
                print(Double.parseDouble(str));
            }else if(str.matches("[- 0-9]+")){
                int i = Integer.parseInt(str);
                if(i > 0 && i < 128)
                    print(Short.parseShort(str));
                else
                    print(i);
            }else{
                print(str);
            }
        }
        bf.close();
        isr.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}

