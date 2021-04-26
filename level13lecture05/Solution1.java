import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        //напишите тут ваш код
        JavarushQuest[] javarushQuest = JavarushQuest.values();
        for(int i = 0; i< javarushQuest.length; i++)
        System.out.println(javarushQuest[i].ordinal());
    }
}
 enum JavarushQuest {
    JAVA_SYNTAX,
    JAVA_CORE,
    JAVA_MULTITHREADING,
    JAVA_COLLECTIONS,
    CS_50,
    ANDROID,
    GAMES
}

