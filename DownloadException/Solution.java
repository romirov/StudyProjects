
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        boolean readFile = true;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while(readFile){
                try(FileInputStream fis = new FileInputStream(bf.readLine())){
                    if(fis.available() < 1000){
                        throw new DownloadException();
                    }

                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
    }

    public static class DownloadException extends Exception {

    }
}

