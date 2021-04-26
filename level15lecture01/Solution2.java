import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            List<String> strings = Files.readAllLines(Paths.get(scanner.nextLine()));
            for (String s: strings) {
                for(int i = 0; i < s.length(); i++){
                    if(s.charAt(i) != ' ' && s.charAt(i) != '.' && s.charAt(i) != ','){
                        System.out.print(s.charAt(i));
                    }
                }
            }
            System.out.println();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
