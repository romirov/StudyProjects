import java.io.*;
import java.lang.Long;
/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerFileName = new BufferedReader(new InputStreamReader(System.in))){
            String fileName1 = readerFileName.readLine();
            String fileName2 = readerFileName.readLine();

            BufferedReader f1reader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter f2writer = new BufferedWriter(new FileWriter(fileName2));

            while(f1reader.ready()){
                String[] data = f1reader.readLine().split("\\s");
                for(String str : data){
                    f2writer.write(Long.toString(Math.round(Double.parseDouble(str))));
                    f2writer.write(" ");
                }
            }
            
            f1reader.close();
            f2writer.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

