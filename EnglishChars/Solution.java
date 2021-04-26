import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int countChars = 0;
        try(FileReader reader = new FileReader(args[0])){
            while(reader.ready()){
                int character = reader.read(); 
                if(character >= (int)'A' && character <= (int)'Z'){
                    countChars++;
                }
                else if(character >= (int)'a' && character <= (int)'z'){
                    countChars++;
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println(countChars);
    }
}

