import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/* 
Встречаемость символов
*/

 class ComparatorTreeMap implements Comparator<Map.Entry<Character, Integer>>{
                        @Override
                        public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
                            return e1.getValue().compareTo(e2.getValue());
                        }
}

public class Solution {
    public static void main(String[] args) {
        if(!args[0].isEmpty()){
            try(FileReader reader = new FileReader(args[0])){
                ComparatorTreeMap ctm = new ComparatorTreeMap();
                Map<Character,Integer> mapFrequencyOfCharacters = new TreeMap<>();//HashMap<Character, Integer>(ctm);
                Character ch = null;
                while(reader.ready()){
                    ch = (char)reader.read();
                    mapFrequencyOfCharacters.put(ch, (mapFrequencyOfCharacters.get(ch) == null)?1:mapFrequencyOfCharacters.get(ch) + 1);
                }
            
         //   System.out.println(mapFrequencyOfCharacters);


            List<Map.Entry<Character, Integer>> list = new LinkedList<>(mapFrequencyOfCharacters.entrySet());
//            list.sort(Comparator.comparing(o -> (o.getValue())));//sortirovka po znacheniyu
            

            for(Map.Entry entry : list){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
   //             SortedSet<Map.Entry<Character, Integer>> sortedset = new TreeSet<Map.Entry<Character, Integer>>(
   //         new Comparator<Map.Entry<Character, Integer>>() {
     //           @Override
       //         public int compare(Map.Entry<Character, Integer> e1,
       //                 Map.Entry<Character, Integer> e2) {
        //            return e1.getValue().compareTo(e2.getValue());
         //       }
           // });
            
             // sortedset.addAll(mapFrequencyOfCharacters.entrySet());

           // System.out.println(sortedset);

            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }else{
            System.out.println("ERROR: Enter file name");
        }
    }
}

