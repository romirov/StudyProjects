import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Set<String> fileParts = new TreeSet<>();
            boolean flag = true;
            while(flag){
                String fileName = reader.readLine();
                if(fileName.equals("end")) break;
                fileParts.add(fileName);
            }
            String[] fileNameArrays = new String[fileParts.size()];
            fileParts.toArray(fileNameArrays);
            String resultFileName = fileNameArrays[0].substring(0,fileNameArrays[0].length() - 6);

            OutputStream bos = new BufferedOutputStream(new FileOutputStream(resultFileName));
            for(String fileName : fileNameArrays){
                try(InputStream bis = new BufferedInputStream(new FileInputStream(fileName))){
                    int lengthFile = bis.available();
                    byte[] data = new byte[lengthFile];
                    bis.read(data);
                    bos.write(data,0,lengthFile);
                }catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            bos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

