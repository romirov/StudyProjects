import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.File;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        try{
            PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(new File("test")));
            Person p = psa.read();
            System.out.println(p);
            psa.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        public Person read() throws IOException{
            //String[] data = new String[6];
            //if(this.fileScanner.hasNext())
                //data = this.fileScanner.next().split(" ");
            if(this.fileScanner.hasNext()){
                //System.out.println(this.fileScanner.next());
                String lastName = this.fileScanner.next();
                String middleName = this.fileScanner.next();
                String firstName = this.fileScanner.next();
                String day = this.fileScanner.next();
                String month = String.valueOf(Integer.parseInt(this.fileScanner.next()) - 1);
                String year = this.fileScanner.next();
                System.out.println(day + "-" + month + "-" + year);
                //String date = day + " "+ month +  " " + year;
            
                Date birthDate = new Date(Integer.parseInt(year) - 1900, Integer.parseInt(month), Integer.parseInt(day));
                //SimpleDateFormat formatter = new SimpleDateFormat("dd MM YYYY");
               // try{
                //    System.out.println(formatter.format(birthDate).toString());
                  //  birthDate = formatter.parse(date); 
                //}catch(ParseException pe){
                 //   pe.printStackTrace();
                //}
                return new Person(firstName, middleName, lastName, birthDate);
            }else return null;
        }

        public void close() throws IOException{
            this.fileScanner.close();
        }
    }
}

class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", lastName, firstName, middleName, birthDate.toString());
    }
}

interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}

