import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file1 = reader.readLine();
            String file2 = reader.readLine();

            FileInputStream fis1 = new FileInputStream(file1);
            byte[] file1Array = new byte[fis1.available()];
            fis1.read(file1Array);
            fis1.close();
            FileInputStream fis2 = new FileInputStream(file2);
            byte[] file2Array = new byte[fis2.available()];
            fis2.read(file2Array);
            fis2.close();
            
            FileOutputStream fos1 = new FileOutputStream(file1);
            fos1.write(file2Array,0,file2Array.length);
            fos1.write(file1Array,0,file1Array.length);
            fos1.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
