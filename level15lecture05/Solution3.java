import java.nio.file.Path;
import java.util.Scanner;

/* 
Абсолютный путь
*/

public class Solution3 {
    public static void main(String[] args) {
        //напишите тут ваш код
        try(Scanner scanner = new Scanner(System.in)){
            Path path = Path.of(scanner.nextLine());
            if(!path.isAbsolute()){
                path = path.toAbsolutePath();
            }
            System.out.println(path.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}


