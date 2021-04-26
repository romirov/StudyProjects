import java.util.Arrays;
import java.util.HashSet;

import static java.util.Arrays.asList;

/* 
Проверка присутствия
*/

public class Solution1 {
    public static HashSet<String> words = new HashSet<>(asList("Если бы меня попросили выбрать язык на замену Java я бы не выбирал".split(" ")));

    public static void checkWords(String word) {
        //напишите тут ваш код
        if(words.contains(word)){
            System.out.println("Слово " + word + " есть в множестве");
        }
        else{
            System.out.println("Слова " + word + " нет в множестве");
        }
    }

    public static void main(String[] args) {
        checkWords("JavaScript");
        checkWords("Java");
    }
}

