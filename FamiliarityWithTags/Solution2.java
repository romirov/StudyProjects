import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Код ниже не решение
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

public class Solution2 {
    public static void main(String[] args) {
        //args[0] = "span";
        if(args.length > 0 && !args[0].isEmpty()){
            String templateTag = args[0];
            try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){

                ArrayList<String> resultList = new ArrayList<>();
                String data = "";
                ArrayList<String> tagsList = new ArrayList<>();
                while(fileReader.ready()){
                    data = fileReader.readLine();
                    char[] characters = data.toCharArray();
                    for(int i = 0; i < characters.length; i++){
                        if(characters[i] == (int)'<'){
                            //если встречаем открывающую скобку
                            String str = "";
                            while(characters[i] != (int) '>'){
                                //считываем от < до > в строку
                                str += String.valueOf(characters[i]);
                                i++;
                            }
                            str += String.valueOf(characters[i]);
                            tagsList.add(str);

                            if(i+1 < characters.length && characters[i+1] != (int)'<'){
                                i++;
                                str = "";
                                while(i < characters.length && characters[i] != (int) '<'){
                                    //считываем между > и < в строку
                                    str += String.valueOf(characters[i]);
                                    i++;
                                }
                                i--;
                                tagsList.add(str);
                            }
                        }
                    }
                }
                //tagsList.forEach(System.out::println);
                //get templateTag from tagsList
                int iResultList = 0;
                int nestingLevel = 0;
                for(int iTagsList = 0; iTagsList < tagsList.size(); iTagsList++){
                    if(tagsList.get(iTagsList).contains("<" + templateTag + " ") ||
                    tagsList.get(iTagsList).contains("<" + templateTag + ">")){
                        //добавляем строку с <> в результат
                        resultList.add(tagsList.get(iTagsList));
                        //System.out.println(resultList.get(iResultList));
                        iResultList = resultList.size();
                        //System.out.println(iResultList);
                    }else if(tagsList.get(iTagsList).contains("</" + templateTag) && iResultList > 0 ){
                        //добавляем </> тег
                            //System.out.println(iResultList );
                            resultList.set(iResultList - 1, resultList.get(iResultList - 1) + tagsList.get(iTagsList));
                            //System.out.println(resultList.get(iResultList - 1));
                            iResultList--;
                            //System.out.println(iResultList );
                        
                    }else if(iResultList > 0){
                        //добавляем данные между <> и </>
                           // System.out.println(iResultList);
                            resultList.set(iResultList - 1, resultList.get(iResultList - 1) + tagsList.get(iTagsList));
                            //System.out.println(resultList.get(iResultList - 1));
                        
                        
                    }
                }
                //System.out.println("------------------------");
                resultList.forEach(System.out::println);
            }catch(IOException ioe){
                ioe.printStackTrace();
            }
        }else{
            System.out.println("Please enter search tag next time");
        }
    }
}