import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Solution {

    static Date birthDate = new Date(87,3,1);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        Locale localeRu = new Locale("ru", "RU");
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE",localeRu);
        String str = formatter.format(date);
        return str;
    }
}
