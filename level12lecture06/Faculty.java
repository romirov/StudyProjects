import java.util.ArrayList;

/* 
Дженерики и студенты
*/

public class Faculty {

    public static void main(String[] args) {
        var students = new ArrayList<Student>();
        students.add(new Student("Акакий"));
        students.add(new Student("Любослав"));
//        students.add("Анатолий");
//        students.add(new Thread());
//        students.add(new Student[]{new Student("Афанасий"), new Student("Платон")});

        printStudentNames(students);
    }

    public static void printStudentNames(ArrayList<Student> students) {
       students.forEach(student -> {
           System.out.println(((Student) student).getName());
       });
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

