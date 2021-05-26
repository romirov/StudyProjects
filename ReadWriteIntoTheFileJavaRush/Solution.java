import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
Реализуй логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для тебя и не участвует в тестировании.
Требования:
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
•	Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
•	Класс Solution.JavaRush должен быть публичным.
•	Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            //File yourFile = new File("test");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            //JavaRush javaRush = new JavaRush("save");
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            //JavaRush loadedObject = new JavaRush("load");
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        
        //test
        //public JavaRush(String saveLoad){
       //     if(saveLoad.contains("save")){
       //         User user = new User();
       //         user.setFirstName("FistName");
        //        user.setLastName("LastName");
        //        user.setBirthDate(new Date());
       //         user.setMale(true);
       //         user.setCountry(User.Country.RUSSIA);
        //        users.add( user );
       //     }
      //  }
        //////////////////////////////////////
        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try( PrintWriter writer = new PrintWriter(outputStream)){
                for(User user : users){
                    writer.write(user.getFirstName() + "\n");
                    writer.write(user.getLastName() + "\n");
                    writer.write(new Long(user.getBirthDate().getTime()).toString() + "\n");
                    writer.write(user.isMale()? "true" : "false");
                    writer.write("\n");
                    writer.write(user.getCountry().toString() + "\n");
                }
                writer.flush();
            }catch(Exception ioe){
                ioe.printStackTrace();
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
                while(reader.ready()){
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    long date = Long.parseLong(reader.readLine());
                    //System.out.println(new Date(date).toString());
                    user.setBirthDate(new Date(date));
                    user.setMale(reader.readLine().contains("true") ? true:false);
                    String country = reader.readLine();
                    if(country.contains("RUSSIA")) user.setCountry(User.Country.RUSSIA);
                    else if(country.contains("UKRAINE")) user.setCountry(User.Country.UKRAINE);
                    else user.setCountry(User.Country.OTHER);
                    
                    users.add(user);
                }
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
