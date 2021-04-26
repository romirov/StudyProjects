 enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код
    public static Month[] getWinterMonths(){
        Month[] monthes = new Month[3];
        int i = 0;
        for(Month month : Month.values()){
            if(month == Month.JANUARY || month == Month.FEBRUARY || month == Month.DECEMBER){
                monthes[i] = month; 
                i++;
            }
        }
        return monthes;
    }
    public static Month[] getSpringMonths(){
        Month[] monthes = new Month[3];
        int i = 0;
        for(Month month : Month.values()){
            if(month == Month.MARCH || month == Month.APRIL || month == Month.MAY){
                monthes[i] = month; 
                i++;
            }
        }
        return monthes;
    }
    public static Month[] getSummerMonths(){
        Month[] monthes = new Month[3];
        int i = 0;
        for(Month month : Month.values()){
            if(month == Month.JUNE || month == Month.JULY || month == Month.AUGUST){
                monthes[i] = month; 
                i++;
            }
        }
        return monthes;
    }
    public static Month[] getAutumnMonths(){
        Month[] monthes = new Month[3];
        int i = 0;
        for(Month month : Month.values()){
            if(month == Month.SEPTEMBER || month == Month.OCTOBER || month == Month.NOVEMBER){
                monthes[i] = month; 
                i++;
            }
        }
        return monthes;
    }
}

public class MonthTest{
    public static void main(String[] args){
        System.out.println(Month.getWinterMonths());
        System.out.println(Month.getSpringMonths());
        System.out.println(Month.getSummerMonths());
        System.out.println(Month.getAutumnMonths());
    }
}
