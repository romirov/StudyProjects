import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        bf.close();
        
        FileInputStream fis = new FileInputStream(fileName);
        Set<Integer> byteSet = new TreeSet<>();
        while(fis.available() > 0){
            byteSet.add(fis.read());
        }
        fis.close();
        //String replace1 = byteSet.toString().replace(',', "");

        //System.out.print(replace1);
        for(Integer i:byteSet)
        System.out.print(i + " ");

        //Iterator<Integer> i = byteSet.iterator();
        //while(i.hasNext())
         //   System.out.print(i.next() + " ");
    }
}

