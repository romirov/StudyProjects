import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try(Scanner scanner = new Scanner(System.in)){
            List<String> strings = Files.readAllLines(Paths.get(scanner.nextLine()));
            for(int i = 0; i < strings.size(); i+=2){
                System.out.println(strings.get(i));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
