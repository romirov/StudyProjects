import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.StringBuilder; 
/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        List<String> strArray = new ArrayList<>();
        int lengthByteArray = 0;
        byte[] byteArray = new byte[1000];
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); FileInputStream fis = new FileInputStream(bf.readLine()); FileOutputStream fos = new FileOutputStream(bf.readLine())){
            while(fis.available() > 0){
                lengthByteArray = fis.read(byteArray);
                sb.append(new String(byteArray, 0, lengthByteArray));
            }
            sb.reverse();
            fos.write(sb.toString().getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
