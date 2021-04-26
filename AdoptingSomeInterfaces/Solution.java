/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
        String str = "1234567";
        if(str.length() < 10) {
            String tempString = "";
            for(int i = 0 ; i < 10 - str.length(); i++) tempString += "0";
            str = tempString + str; 
        }
        System.out.println(String.format("%+d(%s)%s-%s-%s",38,str.substring(0,3),str.substring(3,6),str.substring(6,8),str.substring(8,10)));

    }

    public static class IncomeDataAdapter implements Customer,Contact {
        private IncomeData incomeData;
        
        public IncomeDataAdapter(IncomeData incomeData){
            this.incomeData = incomeData;
        }

        public String getCompanyName(){
            return this.incomeData.getCompany();
        }

        public String getCountryName(){
            return countries.get(this.incomeData.getCountryCode());
        }
        
        public String getName(){
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        public String getPhoneNumber(){
            String str = String.valueOf(this.incomeData.getPhoneNumber());
            if(str.length() < 10) {
                String tempString = "";
                for(int i = 0 ; i < 10 - str.length(); i++) 
                    tempString += "0";
                str = tempString + str;
            }
            return String.format("%+d(%s)%s-%s-%s",this.incomeData.getCountryPhoneCode(),str.substring(0,3),str.substring(3,6),str.substring(6,8),str.substring(8,10));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
