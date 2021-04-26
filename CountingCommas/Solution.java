import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        int lengthArray = 0;
        byte[] array = new byte[10000];
        String string = "";
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); FileInputStream fis = new FileInputStream(bf.readLine())){
            while(fis.available() > 0){
                lengthArray = fis.read(array);
                char[] mas = new String(array, 0, lengthArray).toCharArray();
                for(char i : mas){
                    if(i == ',') count++;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}

