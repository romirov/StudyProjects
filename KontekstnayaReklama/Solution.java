import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
В методе main подмени объект System.out написанной тобой ридер-оберткой.
Твоя ридер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = new PrintStream(System.out);
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(data);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);

        String reklama = "JavaRush - курсы Java онлайн";
        String[] dataStrings = data.toString().split("\n");
        for(int i = 0; i < dataStrings.length; i++){
            System.out.println(dataStrings[i]);
            if((i % 2) == 1)
                System.out.println(reklama);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

