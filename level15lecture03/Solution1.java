import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Пишем символы в файл
*/

public class Solution1 {
    public static void main(String[] args) {
        char[] chars = args[0].toCharArray();
        try (InputStream stream = System.in;
             Scanner scanner = new Scanner(stream);
             BufferedWriter bf = Files.newBufferedWriter(Path.of(scanner.nextLine()))) {
            bf.write(chars, 0, chars.length);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
