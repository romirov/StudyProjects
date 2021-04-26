import java.util.ArrayList;
import java.util.HashMap;

/* 
ArrayList vs HashMap
*/

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(getProgrammingLanguages());
    }

    public static HashMap<Integer, String> getProgrammingLanguages() {
        //напишите тут ваш код
        ArrayList<String> programmingLanguages = new ArrayList<>();
        HashMap<Integer, String> programmingLanguagesHashMap = new HashMap<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("Go");
        programmingLanguages.add("Javascript");
        programmingLanguages.add("Typescript");
        programmingLanguages.add("Python");
        programmingLanguages.add("PHP");
        programmingLanguages.add("C++");
        for(int i = 0; i < programmingLanguages.size(); i++){
            programmingLanguagesHashMap.put(i, programmingLanguages.get(i));
        }   
        return programmingLanguagesHashMap;
    }

}

