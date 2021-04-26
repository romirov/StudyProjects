interface Country {
    String UKRAINE = "Ukraine";
    String RUSSIA = "Russia";
    String MOLDOVA = "Moldova";
    String BELARUS = "Belarus";
}


public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
//        System.out.println(((BelarusianHen) hen).getCountOfEggsPerMonth());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
//                System.out.println(country);
            //напишите тут ваш код
            if(country.equals(Country.RUSSIA)){
                return new RussianHen();
            }else if(country.equals(Country.UKRAINE)){
                return new UkrainianHen();
            }else if(country.equals(Country.MOLDOVA)){
                return new MoldovanHen();
            }else if(country == Country.BELARUS){
                //System.out.println("$$$$$$$");
                //hen = new BelarusianHen();
                //((BelarusianHen) hen).getCountOfEggsPerMonth();
                return new BelarusianHen();
            }
            return hen;
        }
    }
 
    public static abstract class Hen{
        public abstract int getCountOfEggsPerMonth();

        public String getDescription(){
            return "Я - курица.";
        }

    }

    public static class RussianHen extends Hen{
        public int getCountOfEggsPerMonth(){
            return 1;
        }

        public String getDescription(){
            return super.getDescription() + " Моя страна - Россия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }
    }

    public static class UkrainianHen extends Hen{
        public int getCountOfEggsPerMonth(){
            return 2;
        }

        public String getDescription(){
            return super.getDescription() + " Моя страна - Украина. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }

    }
    
    public static class MoldovanHen extends Hen{
        public int getCountOfEggsPerMonth(){
            return 3;
        }

        public String getDescription(){
            return super.getDescription() + " Моя страна - Молдовия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }

    }

    public static class BelarusianHen extends Hen{
        public int getCountOfEggsPerMonth(){
            return 4;
        }

        public String getDescription(){
            return super.getDescription() + " Моя страна - Беларуссия. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        }

    }
}
