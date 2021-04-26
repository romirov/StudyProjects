
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
    private static String fileName;
    public static void main(String[] args) throws Exception {
        List<String> data = new ArrayList<>();
        int id = 0;
        String productName = "";
        String price = "";
        String quantity = "";
        
        if(args.length > 0){
           switch(args[0]){
                case ("-c"):
                    //read file name
                    getFileName();
                    
                    //read file and get largest id from data
                    data = readDataFromFile();
                    id = getLargestIdFromData(data);
                    
                    //increase ID
                        id++;

                   //set productName price quantity
                    for(int i = 1; i < args.length - 2; i++)
                        productName += args[i] + " ";
                    productName = productName.substring(0, productName.length() - 1);
                        
                    //set price
                    price = args[args.length - 2];
                       
                    //set quantity
                    quantity = args[args.length - 1];
                    
                    //add data to the file
                    data.add(String.format("%-8s%-30s%-8s%-4s",id,productName,price,quantity));
                    
                    //write result to the file
                     writeDataToFile(data);    
                break;
                case ("-u"):
                    //read file name
                    getFileName(); 
                        
                    //read file and get Id
                    data = readDataFromFile();
                    id = Integer.parseInt(args[1]);
                   
                   //set productName price quantity
                    for(int i = 2; i < args.length - 2; i++)
                        productName += args[i] + " ";
                    productName = productName.substring(0, productName.length() - 1);
                        
                    //set price
                    price = args[args.length - 2];
                //System.out.println(price);
                       
                    //set quantity
                    quantity = args[args.length - 1];
                        
                    //update data
                    for(String str:data){
                        if(str.substring(0,8).equals(String.format("%-8s",id))){
                            String result =  String.format("%-8s%-30s%-8s%-4s",id,productName,price,quantity); 
                            data.set(data.indexOf(str),result);
                        }
                    }
                        
                    //write result to the file
                    writeDataToFile(data);
                break;
                case ("-d"):
                        //read file name
                        getFileName(); 
                        
                        //read file and get Id
                        data = readDataFromFile();
                        id = Integer.parseInt(args[1]);

                        //update data
                        int idFromData = 0;
                        int index = 0;
                        for(String str:data){
                            idFromData = Integer.parseInt(str.substring(0,8).replace(" ",""));
                            if(id == idFromData){
                                index = data.indexOf(str);
                            }
                        }
                        data.remove(index);
                        
                        //write result to the file
                        writeDataToFile(data);
                break;
           }
        }
    }

    private static void getFileName(){
        //read file name
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        }catch(IOException ioe){
            System.out.print("Error function getFileName: ");
            ioe.printStackTrace();
        }
    }

    private static List<String> readDataFromFile(){
        List<String> data = new ArrayList<>();
        try( BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while(fileReader.ready()){
                String str = fileReader.readLine();
                data.add(str);
            }
        }catch(IOException ioe){
            System.out.print("Error function readDataFromFile:");
            ioe.printStackTrace();
        }
        return data;
    }

    public static int getLargestIdFromData(List<String> data){
        int idFromData = 0;
        int id = 0;
        for(String str:data){
            idFromData = Integer.parseInt(str.substring(0,8).replace(" ",""));
            if(id < idFromData)
                id = idFromData;
        }
        return id; 
    }

    private static void writeDataToFile(List<String> data){
        try(FileWriter fileWriter = new FileWriter(fileName)){
            for(String str : data){
                fileWriter.write(str);
                fileWriter.write('\n');
            }
        }catch(IOException ioe){
            System.out.print("Error function writeDataToFile: ");
            ioe.printStackTrace();
        }
    }
}
