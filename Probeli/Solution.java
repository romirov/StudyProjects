import java.io.FileReader;
import java.io.IOException;

/*
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        double countSymbols = 0;
        double countSpace = 0;
        try(FileReader reader = new FileReader(args[0])){
            while(reader.ready()){
                int character = reader.read(); 
                if(Character.isSpaceChar((char) character)){
                    countSpace++;
                }
                countSymbols++;
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        //System.out.println(countSpace);
        //System.out.println(countSymbols);
        //System.out.println(countSpace/(countSymbols * 100));
        double result = countSpace/countSymbols * 100;
        System.out.printf("%.2f",result);
    }
}

