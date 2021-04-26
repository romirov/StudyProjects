import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/* 
Только по-очереди!
*/

public class Solution {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        //add your code here - добавьте код тут
        t1.start();
        //Thread.sleep(10000);
        t1.join();
        
        t2.start();
        //Thread.sleep(10000);
        t2.join();


        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread{
        public List<String> str = new ArrayList<>();
        public void run(){
            try{
                Thread.sleep(500);
                for(int i = 0; i < 3; i++){
                    str.add(Solution.reader.readLine());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public void printResult(){
            for(int i = 0;i < str.size(); i++){
                System.out.print(str.get(i) + " ");
            }
            System.out.println("");
        }
    }
}
