import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
            int i = 1;
            String name = "";
            int id = 0;
        //start here - начни тут
        switch(args[0]){
            case "-c":
                synchronized(allPeople){
                    for(i = 1; i < args.length; i++){
                        if(args[i].length() == 1){
                            if(args[i].contains("м")){
                                try{
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    allPeople.add(Person.createMale(name.substring(0, name.length() - 1),sdf.parse(args[++i])));
                                }catch(ParseException e){
                                    e.printStackTrace();
                                }
                            }else{
                                try{
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    allPeople.add(Person.createFemale(name.substring(0, name.length() - 1),sdf.parse(args[++i])));
                                }catch(ParseException e){
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(allPeople.size() - 1);
                            name = "";
                        }else{
                            name += args[i] + " ";
                        }
                    }
                }
                allPeople.forEach((p) -> System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDate()));
                break;
            case "-u":
                synchronized(allPeople){
                    for(i = 1; i < args.length; i++){
                        id = Integer.parseInt(args[i]);
                        i++;
                        if(id < allPeople.size()){
                            while(args[i].length() > 1 && !args[i].contains("м")){
                                name += args[i] + " ";
                                i++;
                            }
                            if(args[i].contains("м")){
                                try{
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    allPeople.set(id, Person.createMale(name.substring(0, name.length() - 1),sdf.parse(args[++i])));
                                }catch(ParseException e){
                                    e.printStackTrace();
                                }
                            }else{
                                try{
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
                                    allPeople.set(id, Person.createFemale(name.substring(0, name.length() - 1),sdf.parse(args[++i])));
                                }catch(ParseException e){
                                    e.printStackTrace();
                                }
                            }
                            name = "";
                        }
                    }
                }
                allPeople.forEach((p) -> System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDate()));
                break;
            case "-d":
                synchronized(allPeople){
                    for(i = 1; i < args.length; i++){
                        id = Integer.parseInt(args[i]);
                        if(id < allPeople.size()){
                            allPeople.get(id).setName(null);
                            allPeople.get(id).setSex(null);
                            allPeople.get(id).setBirthDate(null);
                        }
                    }
                }
                allPeople.forEach((p) -> System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDate()));
                break;
            case "-i":
                synchronized(allPeople){
                    for(i = 1; i < args.length; i++){
                        id = Integer.parseInt(args[i]);
                        if(id < allPeople.size()){
                            System.out.print(allPeople.get(id).getName() + " ");
                            if(allPeople.get(id).getSex() == Sex.MALE){
                                System.out.print("м" + " ");
                            }else if(allPeople.get(id).getSex() == Sex.FEMALE){
                                System.out.print("ж" + " ");
                            }
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY");
                            System.out.println(formatter.format(allPeople.get(id).getBirthDate()));
                        }
                    }
                }
                break;
        }
    }
}

class Person {
    private String name;
    private Sex sex;
    private Date birthDate;

    private Person(String name, Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Person createMale(String name, Date birthDate) {
        return new Person(name, Sex.MALE, birthDate);
    }

    public static Person createFemale(String name, Date birthDate) {
        return new Person(name, Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

enum Sex {
    MALE,
    FEMALE
}

