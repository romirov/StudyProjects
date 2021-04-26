import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Solution1 {

    static ZonedDateTime zonedDateTime = ZonedDateTime.now();

    public static void main(String[] args) {
        //напишите тут ваш код
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("e d.M.yy HH:mm:ss.n VV");
        String str = formatter.format(zonedDateTime);
        System.out.println(str);
    }
}

