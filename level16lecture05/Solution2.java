import java.time.Instant;
import java.lang.ArithmeticException;

public class Solution2 {

    public static void main(String[] args) throws ArithmeticException {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() throws ArithmeticException{
        //напишите тут ваш код
        Instant instant = Instant.ofEpochMilli(Instant.MAX.toEpochMilli());
        return instant;
    }

    static Instant getMaxFromSeconds() {
        //напишите тут ваш код
            Instant instant = Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
        return instant;
    }

    static Instant getMaxFromSecondsAndNanos() {
        //напишите тут ваш код
            Instant instant = Instant.ofEpochSecond(Instant.MAX.getEpochSecond(),Instant.MAX.getNano());
        return instant;
    }
}

