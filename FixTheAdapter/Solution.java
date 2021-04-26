import java.util.HashMap;
import java.util.Map;
/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    
    static{
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        Customer customer = new TestCustomer();
        Contact contact = new TestContact();
        DataAdapter da = new DataAdapter(customer, contact);

        System.out.println(da.getCountryCode());
        System.out.println(da.getCompany());
        System.out.println(da.getContactFirstName());
        System.out.println(da.getContactLastName());
        System.out.println(da.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }
        
        public String getCountryCode(){
            for(String key: countries.keySet()){
                if(countries.get(key).equals(this.customer.getCountryName())){
                    return key;
                }
            }

            return null;
        }

        public String getCompany(){
            return this.customer.getCompanyName();
        }

        public String getContactFirstName(){
            String[] name = this.contact.getName().split(", ");
            String firstName = name[1];
            return firstName;
        }

        public String getContactLastName(){
            String[] name = this.contact.getName().split(", ");
            String lastName = name[0];
            return lastName;
        }

        public String getDialString(){
            String[] phoneNumberArray = contact.getPhoneNumber().trim().split("[+()-]");
            String phoneNumber = "";
            for(String str : phoneNumberArray)
                    phoneNumber += str;

            return "callto://+" + phoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }

    public static class TestCustomer implements Customer{
        private String companyName = "JavaRush Ltd.";
        private String countryName = "Ukraine";
        public String getCompanyName(){
            return companyName;
        }
        public String getCountryName(){
            return countryName;
        }
    }

    public static class TestContact implements Contact{
        private String name = "Ivanov, Ivan";
        private String phoneNumber = "+38(050)123-45-67";
        public String getName(){
            return name;
        }
        public String getPhoneNumber(){
            return phoneNumber;
        }

    }
}
