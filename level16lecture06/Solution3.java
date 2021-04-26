import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution3 {

    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Zulu");
        ZoneId zone2 = ZoneId.of("Etc/GMT+8");
        System.out.println(ZonedDateTime.now(zone1));
        System.out.println(ZonedDateTime.now(zone2));

        LocalDateTime time = changeZone(LocalDateTime.of(2020, 3, 19, 1, 40), zone1, zone2);
        System.out.println(time);
    }

    static LocalDateTime changeZone(LocalDateTime fromTime, ZoneId fromZone, ZoneId toZone) {
        //напишите тут ваш код
        ZonedDateTime zdt = ZonedDateTime.of(fromTime, fromZone);
        ZonedDateTime zdt1 = zdt.withZoneSameInstant(toZone);
        LocalDateTime toTime = LocalDateTime.of(zdt1.toLocalDate(), zdt1.toLocalTime());
        return toTime;
    }
}
