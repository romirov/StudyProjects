import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(reader.readLine()))){
            
            while(fReader.ready()){
                int character = fReader.read();
                if((char) character == '.'){
                    fWriter.write((int)'/');
                }else {
                    fWriter.write(character);
                }
            }

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

