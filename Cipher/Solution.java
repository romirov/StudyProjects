import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2])){
        switch (args[0]){
            case ("-e"):
               while(fis.available() > 0)
                   fos.write(fis.read() + 1);
            break;
            case ("-d"):
               while(fis.available() > 0)
                   fos.write(fis.read() - 1);
            break;
        }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}

