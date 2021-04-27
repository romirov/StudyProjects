import java.io.*;

/* 
Дублируем текст
Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить весь текст и на консоль и в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileOutputStream fWriter = new FileOutputStream(reader.readLine())){
        
            PrintStream console = System.out;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PrintStream stream = new PrintStream(outputStream);

            System.setOut(stream);

            testString.printSomething();

            System.setOut(console);

            String result = outputStream.toString();

            System.out.print(result);
            fWriter.write(result.getBytes());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
