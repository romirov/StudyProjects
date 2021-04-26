import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in))){
            
            boolean flag = true;
            String fileName = "";
            while(flag){
                fileName = readerConsole.readLine();
                try(FileReader file = new FileReader(fileName)){

                }catch(FileNotFoundException fnfe){
                    System.out.println(fileName);
                    flag = false;
                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

