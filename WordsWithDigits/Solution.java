import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) {
        try{
            if(!args[0].isEmpty() && !args[1].isEmpty()){
                try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))){
                    String result = "";
                    while(fileReader.ready()){
                        String[] wordsInTheString = fileReader.readLine().split("\\s");
                        for(String word : wordsInTheString){
                            int count = 0;
                            char[] symbols = word.toCharArray();
                            //search num
                            for(char ch: symbols){
                                if(ch >= '0' && ch <= '9'){
                                    count++;
                                    break;
                                    
                                }
                            }
                            //seach letter 
                            for(char ch : symbols){
                                if((int)ch < (int)'0' || (int)ch > (int)'9'){
                                    count++;
                                    break;

                                }
                            }
                            if(count == 2)
                                result = result + word + " ";
                        }
                    }
                   // System.out.println(result);
                    if(!result.isEmpty()){
                        result = result.substring(0, result.length() - 1);
                        fileWriter.write(result, 0, result.length());
                    }
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }catch(ArrayIndexOutOfBoundsException aioobe){
            aioobe.printStackTrace();
        }
    }
}

