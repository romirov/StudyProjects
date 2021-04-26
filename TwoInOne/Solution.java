import java.io.*;
/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(reader.readLine(),true);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine())){
            while(file2.available()>0)
                file1.write(file2.read());
            while(file3.available()>0)
                file1.write(file3.read());

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
