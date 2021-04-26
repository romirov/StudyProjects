import java.util.Collections;
import java.util.HashSet;

/* 
Оформляем возврат
*/

public class Solution {

    public static void main(String[] args) {
        String[] array = {"Через", "три", "года", "я", "буду", "Senior", "Java", "Developer"};
        for(String s : array) {
            System.out.println(s);
        }
        System.out.println("___________________________________");

        HashSet<String> hashSet = arrayToHashSet(array);
        for(String s : hashSet) {
            System.out.println(s);
        }
    }

    public static HashSet<String> arrayToHashSet(String[] strings) {
        //напишите тут ваш код
        HashSet<String> hashSet = new HashSet<>();
        for(String str : strings){
            hashSet.add(str);
        }
        return hashSet;
    }

}
