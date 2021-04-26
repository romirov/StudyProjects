import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) { 
        String id = "";
        String productName = "";
        String price = "";
        String quantity = "";
        
        String fileName = "";
        if(!args[0].isEmpty() && args[0].matches("[\\d]+")){
            try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
                id = args[0];
                fileName = consoleReader.readLine(); 
                if(fileName.isEmpty()){
                    System.out.println("ERROR: File name not entered!!!");
                    System.exit(0);
                }

                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                
                while(fileReader.ready()){
                    String str = fileReader.readLine();
                    String[] stringData = str.split(" ");

                    //System.out.println(id);
                    if(stringData[0].equals(id)){
                        System.out.println(str);
                    }
                }

                fileReader.close();
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }else{
            System.out.println("ERROR: ID not entered!!!");
        }
    }
}
