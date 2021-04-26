import java.io.*;

/* 
Разделение файла
*/

public class Solution1 {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream file1 = new FileInputStream(reader.readLine());
                FileOutputStream file2 = new FileOutputStream(reader.readLine());
                FileOutputStream file3 = new FileOutputStream(reader.readLine());
            ){
                int lenFile1 = file1.available();
                //if((lenFile1 % 2) == 0){
                //byte[] byteArrayToFile2 = new byte[lenFile1/2];
               // byte[] byteArrayToFile3 = new byte[lenFile1/2];

                System.out.println(lenFile1);
                byte[] byteArrayFile1 = new byte[file1.available()];
                file1.read(byteArrayFile1);
                if((lenFile1 % 2) == 0){
                    file2.write(byteArrayFile1, 0, lenFile1/2);
                    file3.write(byteArrayFile1, lenFile1/2, lenFile1/2);
                }else{
                    file2.write(byteArrayFile1, 0, lenFile1/2 + 1);
                    file3.write(byteArrayFile1, lenFile1/2+1, lenFile1/2);
                }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
