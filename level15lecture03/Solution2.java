import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

/* 
Задом наперед
*/

public class Solution2 {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        printSomething(args[0]);
        String result = outputStream.toString();
        //напишите тут ваш код
        outputStream.reset();
        char[] charArray = result.toCharArray();
        for(int i = charArray.length - 1; i >= 0; i-- ){
            stream.print(charArray[i]);
        }
        System.out.println(outputStream.toString());
    }
    public static void printSomething(String str) throws IOException {
        stream.write(str.getBytes());
    }
}
