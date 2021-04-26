import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution4 {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
        //напишите тут ваш код
        try(Scanner scanner = new Scanner(System.in)){
            while(scanner.hasNextLine()){
                Path path = Path.of(scanner.nextLine());
                if(Files.isRegularFile(path) && Files.exists(path)){
                    System.out.println(path.toString() + THIS_IS_FILE);
                }else if(Files.isDirectory(path) && Files.exists(path)){
                    System.out.println(path.toString() + THIS_IS_DIR);
                }else{
                    break;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
