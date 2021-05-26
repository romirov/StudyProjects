import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для тебя и не участвует в тестировании.
Требования:
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
•	Класс Solution.Human не должен поддерживать интерфейс Serializable.
•	Класс Solution.Human должен быть публичным.
•	Класс Solution.Human не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            //File your_file_name = new File("test");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(PrintWriter writer = new PrintWriter(outputStream)){
                writer.write(this.name);
                writer.write("\n");
                for(Asset asset : assets){
                    writer.write(asset.getName() + " " + asset.getPrice() + "\n");
                }
                writer.flush();
            }catch(Exception ioe){
                ioe.printStackTrace();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
                this.name = reader.readLine();
                while(reader.ready()){
                    String[] asset = reader.readLine().split(" ");
                    assets.add(new Asset(asset[0], Double.parseDouble(asset[1])));
                }
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
