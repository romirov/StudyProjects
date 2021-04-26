import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1986,4,5);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        Locale locale = new Locale("ru","RU");
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE",locale);
        String str = formatter.format(calendar.getTime());
        return str;
    }
}

