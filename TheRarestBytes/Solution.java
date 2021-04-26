import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        bf.close();
        
        FileInputStream fis = new FileInputStream(fileName);
        ArrayList<Integer> byteArrayList = new ArrayList<>();
        while(fis.available() > 0){
            byteArrayList.add(fis.read());
        }
        fis.close();

        //ArrayList<Integer> sortedByteArrayList = (Integer)
        System.out.println(byteArrayList.toString());
        Collections.sort(byteArrayList);
        System.out.println(byteArrayList.toString());

        for(Integer i:byteArrayList){
            if(Collections.frequency(byteArrayList,i) == 1){
                System.out.print(i + " ");
            }
        }
    }
}

