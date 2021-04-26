import java.util.ArrayList;
import java.util.Arrays;

/* 
Останется только Java
*/

public class Solution1 {
    public static ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList("C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));

    public static void main(String[] args) {
        //напишите тут ваш код
        programmingLanguages.remove("C");
        programmingLanguages.remove("C++");
        programmingLanguages.remove("Python");
        programmingLanguages.remove("JavaScript");
        programmingLanguages.remove("Ruby");
        programmingLanguages.remove("Pascal");
    }
}
