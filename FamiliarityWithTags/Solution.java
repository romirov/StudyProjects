import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.HashMap;
/* 
Знакомство с тегами
Считай с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

public class Solution {
    public static void main(String[] args) {
        if(args.length > 0 && !args[0].isEmpty()){
            String templateTag = args[0];
            try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
                
                ArrayList<String> stringArray = new ArrayList<>();
                //HashMap<Integer, Integer> indexesTagInString = new HashMap<>();
                //int countTemplateTag = 0;
                String data = "";
                while(fileReader.ready()){
                    data += fileReader.readLine();
                }
                char[] characters = data.toCharArray();
                //System.out.println(str);
                //разбираем данные на теги
                for(int i = 0 ; i < characters.length; i++){
                    if(characters[i] == (int)'<'){
                        //если встречаем открывающую скобку
                        String str = "";
                        while(characters[i] != (int) '>'){
                            //считываем от < до > в строку
                            str += String.valueOf(characters[i]);
                            i++;
                        }
                        str += String.valueOf(characters[i]);
                        stringArray.add(str);
                        
                        if(i+1 < characters.length && characters[i+1] != (int)'<'){
                            i++;
                            str = "";
                            while(characters[i] != (int) '<'){
                                //считываем между > и < в строку
                                str += String.valueOf(characters[i]);
                                i++;
                            }
                            i--;
                            stringArray.add(str);
                        }
                    }
                }
                //
                ArrayList<String> result = new ArrayList<>();
                int count = 0;
                //String[] strings = stringArray.toArray();
                int index = 0;
                boolean flagVlojennosti = false;
                for(String str : stringArray){
                    
                    if(str.contains("<" + templateTag)){
                        if(flagVlojennosti){
                            //если строка с искомым тегом уже есть в результате и в списке строк видим еще один открывающий тег
                            for(int j = index; j < index + count; j++){
                                result.set(j, result.get(j) + str);
                            }
                            result.add(str);
                            count++;
                        }else{
                            //если строки с искомым тегом еще нет в результате и в списке строк видим открывающий тег
                            result.add(str);
                            count++;
                            index = result.size() - 1;
                            flagVlojennosti = true;
                            //System.out.println(indexFromString + " " + count);
                        }
                    }else if(str.contains("</" + templateTag)){
                        //если в списке строк видим закрывающий искомый тег
                        for(int j = index; j < index + count; j++){
                            result.set(j, result.get(j) + str);
                        }
                        count--;
                        flagVlojennosti = false;
                    }else{
                        //строки между отрывающим и закрывающим искомыми тегами
                        for(int j = index; j < index + count; j++){
                            result.set(j, result.get(j) + str);
                        }
                    }
                    
                }
                ////////
                //stringArray.forEach(System.out::println);
                //System.out.println("===============result==============");
                result.forEach(System.out::println);
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }else{
            System.out.println("Please enter search tag next time");
        }
    }
}
