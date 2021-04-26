import java.nio.file.Path;
import java.util.Scanner;

/* 
Зри в корень
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try(Scanner scanner = new Scanner(System.in)){
            Path path = Path.of(scanner.nextLine());
            System.out.println(path.getRoot());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

