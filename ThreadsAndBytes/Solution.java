import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;
/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            boolean flag = true;
            String fileName = "";
            while(flag){
                fileName = reader.readLine();
                if(fileName.equals("exit")) break;

                Thread thread = new ReadThread(fileName);
                thread.start();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            Map<Integer,Integer> sortedBytes = new TreeMap<>();
            try(FileInputStream fis = new FileInputStream(fileName)){
                byte[] data = new byte[fis.available()];
                fis.read(data);
                for(byte b : data){
                    Integer byteVariable = (int)b;
                    sortedBytes.put(byteVariable,(sortedBytes.get(byteVariable) == null)?1:sortedBytes.get(byteVariable) + 1);
                }
                List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(sortedBytes.entrySet());
                list.sort(Comparator.comparing((o) -> o.getValue()));
                synchronized(Solution.class){
                    resultMap.put(fileName,list.get(list.size() - 1).getKey());
                }
                System.out.println(resultMap);
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}

