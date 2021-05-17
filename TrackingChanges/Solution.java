import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения

Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)
 
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)
 
строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try(BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader originFileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            BufferedReader editedFileReader = new BufferedReader(new FileReader(consoleReader.readLine()))){
            //take data from 1st file
            List<String> originFile = new ArrayList<>();
            while(originFileReader.ready()){
                originFile.add(originFileReader.readLine());
            }
            //take data from 2nd file
            List<String> editedFile = new ArrayList<>();
            while(editedFileReader.ready()){
                editedFile.add(editedFileReader.readLine());
            }
            
            int i = 0;
            int j = 0;
            while(i < originFile.size() && j < editedFile.size()){
                if(!originFile.get(i).isEmpty() && !editedFile.get(j).isEmpty()){
                    if(originFile.get(i).equals(editedFile.get(j))){
                    //если совпадают строки
                        lines.add(new LineItem(Type.SAME, originFile.get(i)));
                    }else{
                    //если строки в оригинальном и новом файлах не равны
                        if(j+1 < editedFile.size()){
                            if(editedFile.get(j + 1).equals(originFile.get(i))){
                            //если совпадают строки
                               lines.add(new LineItem(Type.SAME, originFile.get(i)));
                                lines.add(new LineItem(Type.ADDED, editedFile.get(j)));
                                j+=1;
                            }else{
                                lines.add(new LineItem(Type.REMOVED, originFile.get(i)));
                                lines.add(new LineItem(Type.ADDED, editedFile.get(j)));
                            }
                        }
                    }
                }else if(!originFile.get(i).isEmpty() && editedFile.get(j).isEmpty()){
                    //если строка в оригинальном файле не пустая, а в новом пустая
                    lines.add(new LineItem(Type.REMOVED, originFile.get(i)));
                    
               }else if(originFile.get(i).isEmpty() && !editedFile.get(j).isEmpty()){
                //если строка в оригинальном файле пустая, а в новом не пустая
                    lines.add(new LineItem(Type.ADDED, editedFile.get(j)));
                }
                i++;j++;
            } 

           if(j < editedFile.size()){
                lines.add(new LineItem(Type.ADDED, editedFile.get(j)));
               j++;
           }

           if(i < originFile.size()){
                lines.add(new LineItem(Type.REMOVED, originFile.get(i)));
                j++;
            }

            

            lines.forEach((o) -> System.out.println(o.type + " " + o.line));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
