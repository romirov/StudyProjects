import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш ко
        Scanner scannner = new Scanner(System.in);
        try(InputStream input = Files.newInputStream(Paths.get(scannner.nextLine())); OutputStream output= Files.newOutputStream(Paths.get(scannner.nextLine()))){
            byte[] buffer = new byte[2]; // 2b
            while(input.available() > 0){
                if(input.available() > 1){
                    int real = input.read(buffer);
                    byte[] temp = new byte[2]; // 2b
                    temp[0] = buffer[1];
                    temp[1] = buffer[0];
                    output.write(temp, 0, real);
                }else{
                    output.write(input.read());
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            if(scannner != null){
                scannner.close();
            }
        }
    }
}

