import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Решаем пример

В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9

*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);

        String[] templateString = outputStream.toString().split(" ");

        long firstNum = Long.parseLong(templateString[0]);
        long secondNum = Long.parseLong(templateString[2]);
        long resultNum = 0;
        switch(templateString[1]){
            case "+":
                resultNum = firstNum + secondNum;
                break;
            case "-":
                resultNum = firstNum - secondNum;
                break;
            case "*":
                resultNum = firstNum * secondNum;
                break;
        }
        System.out.print(firstNum + " " + templateString[1] + " " + secondNum + " = " + resultNum);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


