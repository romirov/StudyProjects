import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bf.readLine();
            FileInputStream fis = new FileInputStream(fileName);
            int i = fis.read();
            while(fis.available() > 0){
                int b = fis.read();
                if(i > b) i = b;
            }
            fis.close();
            bf.close();
            System.out.println(i);
    }
}

