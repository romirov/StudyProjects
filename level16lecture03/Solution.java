import java.time.LocalDate;

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate localdate = LocalDate.now();
        return localdate;
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate localdate = LocalDate.of(2020,9,12);
        return localdate;
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        LocalDate ld = LocalDate.of(2020,9,12);
        System.out.println(ld.getDayOfYear());
        LocalDate lde = LocalDate.ofYearDay(ld.getYear(),ld.getDayOfYear());
        return lde;
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        LocalDate ld = LocalDate.of(2020,9,12);
        System.out.println(ld.toEpochDay());
        LocalDate lde = LocalDate.ofEpochDay(ld.toEpochDay());
        return lde;
    }
}

