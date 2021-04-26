import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try{
            Solution solution = new Solution();
            solution.joinData();
        }catch(CorruptedDataException cde){
            System.out.println("AllLines does not contain all strings from forRemoveLines");
        }
    }

    public void joinData() throws CorruptedDataException {
        String fileName1 = "";
        String fileName2 = "";
        //read 1st & 2nd file names 
        try(BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName1 = fileNameReader.readLine();
            fileName2 = fileNameReader.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        //read 1st file
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))){
            while(fileReader.ready()){
                allLines.add(fileReader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        //read 2nd file
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName2))){
            while(fileReader.ready()){
                forRemoveLines.add(fileReader.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}


class CorruptedDataException extends IOException {
}

