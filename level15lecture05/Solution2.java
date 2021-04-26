
import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution2 {
    public static void main(String[] args) {
        Path path1 = Path.of("c:\\windows\\projects\\note.txt");
        Path path2 = Path.of("c:\\windows\\");
        Path result = path1.relativize(path2);
        System.out.println(result.toString());
    }
}


