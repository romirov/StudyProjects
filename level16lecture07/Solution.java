import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String[] args) {
        //напишите тут ваш код
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин");
        String str = formatter.format(localDateTime);
        System.out.println(str);
    }
}

