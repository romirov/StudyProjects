import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream file1 = new FileInputStream(reader.readLine());
                FileOutputStream file2 = new FileOutputStream(reader.readLine());
                FileOutputStream file3 = new FileOutputStream(reader.readLine());
            ){
            int lenFile1 = file1.available();
            int count = 0;
            while(file1.available() > 0){
                if(count <= (lenFile1 / 2)){
                    file2.write(file1.read());
                }else if(count > (lenFile1 / 2)){
                    file3.write(file1.read());
                }
                count++;
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

