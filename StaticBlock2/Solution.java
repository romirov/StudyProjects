import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Scanner;
/* 
Статики-2
*/

public class Solution {
    public static int A;
    public static int B;
    
    static{
        InputStream is = null;
        Scanner scanner = null;
        try{
            is = System.in;
            scanner = new Scanner(is);
            A = scanner.nextInt();
            B = scanner.nextInt();
            scanner.close();
            is.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}

