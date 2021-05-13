import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader originFileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            BufferedReader editedFileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
            //take data from 1st file
            List<String> originFile = new ArrayList<>();
            while(originFileReader.ready()){
                originFile.add(originFileReader.readLine());
            }
            //take data from 2nd file
            List<String> editedFile = new ArrayList<>();
            while(editedFileReader.ready()){
                editedFile.add(editedFileReader.readLine());
            }

            

            //test
            lines.forEach((o) -> System.out.println(o.type + " " + o.line));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }




    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
