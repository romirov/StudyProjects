import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));FileReader fileReader = new FileReader(reader.readLine()); FileWriter fileWriter = new FileWriter(reader.readLine())){
            
            while(fileReader.ready()){
                char[] data = new char[1000];
                int lengthData = fileReader.read(data);

                for(int i = 1; i < lengthData; i+=2){
                    fileWriter.write(data[i]);
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

