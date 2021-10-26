package dirtraversal;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Класс для обхода заданной директории и поддиректорий
 * @author Hanza
*/
public class DirTraversal{
    public static void main(String... args){
        Logger logger = Logger.getLogger(DirTraversal.class.getName());
        logger.log(Level.INFO, "Please enter directory for checking:");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        File pathDir = new File(str);
        List<File> resultFilesList = new ArrayList<>();

        if(pathDir.exists() && pathDir.isDirectory()) {
            resultFilesList.addAll(Arrays.asList(pathDir.listFiles()));
            resultFilesList.addAll(directoryTraversal(resultFilesList));
            resultFilesList.forEach(System.out::println);
        } else {
            logger.log(Level.SEVERE, "Error: you entered not a directory.");
        }

        console.close();
    }

    /**
     * Метод рекурсивно обходящий заданный список файлов и директорий
     * @param fileList - список директорий и фалов, которые необходимо обойти
     * @return возвращает список директорий и файлов, которые обошел
    */	
    private static List<File> directoryTraversal(List<File> fileList) {
        List<File> resultFilesList = new ArrayList<>();
        for(File file : fileList) {
            if (file.isDirectory() && !Arrays.asList(file.listFiles()).isEmpty()){
                if(!fileList.contains(file.listFiles()[0])){
                    fileList.addAll(Arrays.asList(file.listFiles()));
                    resultFilesList.addAll(directoryTraversal(fileList));
                    return resultFilesList;
                }
            }
        }

        return resultFilesList;
    }
}
