import java.util.ArrayList;

/* 
Выводим в консоли разные типы
*/

public class Solution1 {

    public static void printAnything(ArrayList arrayList) {
        arrayList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        var arrayList = new ArrayList<>();
        arrayList.add(15);
        arrayList.add("Hello");
        arrayList.add(154);
        arrayList.add("string");

        printAnything(arrayList);
    }
}
