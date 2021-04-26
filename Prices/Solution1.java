import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
import java.io.IOException;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length > 0)
        switch(args[0]){
            case ("-c"):
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                String file = reader.readLine();
                BufferedReader readerFile = new BufferedReader(new FileReader(file));
                List<String> strings = new ArrayList<>(); 
                while(readerFile.ready()){
                    strings.add(readerFile.readLine());
                }
                readerFile.close();
                //get id
                int id = 0;
                if(strings.size() > 0){
                    for(String str : strings){
                        //System.out.println(str.substring(0,7).replace(" ",""));
                        if(str.substring(0,8).contains(" ")){
                            if(id < Integer.parseInt(str.substring(0,8).replace(" ",""))){
                                id = Integer.parseInt(str.substring(0,8).replace(" ",""));
                            }
                        }else{
                            id = Integer.parseInt(str.substring(0,8));
                        }
                    }
                }
                id++;
                //create string for file
                StringBuilder result = new StringBuilder();
                
                //add id
                int i = 0;
                if(String.valueOf(id).length() <= 8){
                    result.append(String.valueOf(id));
                    i = String.valueOf(id).length();
                    while( i < 8){
                        result.append(" ");
                     i++;
                    }
                }else break;
                //add productName
                String productName = "";
                for(int ii = 1;ii < args.length - 2; ii++){
                    productName += args[ii] + " ";
                }
                productName = productName.substring(0, productName.length() - 1);
                i = productName.length();
                if(i <= 30){
                    result.append(productName);
                    while(i < 30){
                        result.append(" ");
                        i++;
                    }
                }else result.append(productName.substring(0,29));
                //add price
                i = args[args.length-2].length();
                if(i <= 8){
                    result.append(args[args.length-2]);
                    while(i < 8){
                        result.append(" ");
                         i++;
                    }
                }else break;
                //add quantity
                i = args[args.length-1].length();
                if(i <= 4){
                    result.append(args[args.length-1]);
                    while(i < 4){
                        result.append(" ");
                        i++;
                    }
                }else break;

                //write result to file
                strings.add(result.toString());
                FileWriter fileWriter = new FileWriter(file);

                for(String string : strings){
                    fileWriter.write(string);
                    fileWriter.write('\n');
                }
                fileWriter.close();

            }catch(IOException ioe){
                ioe.printStackTrace();
            }

            break;
        }
    }
}
