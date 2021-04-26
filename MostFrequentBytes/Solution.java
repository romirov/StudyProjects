import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.util.*;
/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        bf.close();
        
        FileInputStream fis = new FileInputStream(fileName);
        ArrayList<Integer> byteList = new ArrayList<>(); 
        while(fis.available() > 0){
            byteList.add(fis.read());
        }
        int count = 0;
        int countTemp = 0;
        TreeMap<Integer,Integer> resultMap = new TreeMap<>();
        for(Integer i : byteList){
            countTemp = Collections.frequency(byteList, i);
            resultMap.put(i, countTemp);
            if(count < countTemp)
                count = countTemp;
        }
        
        for(Map.Entry entry : resultMap.entrySet()){
            if((Integer)entry.getValue() == count)
                System.out.print(entry.getKey() + " ");
        }
        fis.close();
    }
}
