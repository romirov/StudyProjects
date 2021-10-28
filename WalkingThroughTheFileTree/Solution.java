package walkingthroughthefiletree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс, кототорый обходит заданную директорию и поддиректории, 
 * ищет файлы с расширением .txt и весом <= 50 байт,
 * записывает содержимое списка собранных файлов в указанный файл переименнованный в allFilesContent.txt
 */
public class Solution {
    public static void main(String[] args) throws NullPointerException, FileNotFoundException {
        if(args.length < 2) {
            System.out.println("Please enter 2 argument for programm");
            throw new NullPointerException();
        }

        File checkingDir = new File(args[0]);//путь к директории
        if(!FileUtils.isExist(checkingDir)) {
            System.out.println("Please create directory " + checkingDir.getName());
            throw new FileNotFoundException();
        }

        File resultFileAbsolutePath = new File(args[1]);//имя (полный путь) существующего файла, который будет содержать результат
        File destFile = new File(resultFileAbsolutePath.getParentFile() + "/allFilesContent.txt");
        if(FileUtils.isExist(destFile)) {
            FileUtils.deleteFile(destFile);
        }

        FileUtils.renameFile(resultFileAbsolutePath, destFile);
        
        try(FileOutputStream fos = new FileOutputStream(resultFileAbsolutePath)){
            List<File> allFilesList = new ArrayList<>();
            allFilesList.addAll(Arrays.asList(checkingDir.listFiles()));
            allFilesList.addAll(directoryTraversal(allFilesList));

            List<File> resultFilesList = new ArrayList<>();
            resultFilesList.addAll(checkDirOrFile(allFilesList));

            //сортируем список файлов с расширением .txt и весом <= 50 байт
            resultFilesList.sort(Comparator.comparing((file) -> file.getName()));

            resultFilesList.forEach(file -> {
                try(FileInputStream fis = new FileInputStream(file)){
                    int fileByteSize = fis.available();
                    byte[] fileContentInByte = new byte[fileByteSize];
                    fis.read(fileContentInByte, 0, fileByteSize);
                    
                    fos.write(fileContentInByte);
                    fos.write("\n".getBytes());
                } catch (IOException e) {
                    System.out.println("IOException in file " + file.getPath());
                }
            });
        } catch (IOException e) {
            System.out.println("IOException in file " + resultFileAbsolutePath.getPath());
        }
    }
    /**
     * Метод для рекурсивного обхода директорий
     * @param fileList - список директорий для обхода
     * @return возвращает список всех найденных файлов и поддиректорий
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

    /**
     * Метод для получения из списка файлов и дирикторий только файлов с расширением .txt и весом <= 50 байт 
     * @param fileList - список файлов и директорий для проверки
     * @return возвращает список файлов с расширением .txt и весом <= 50 байт
     */
    private static List<File> checkDirOrFile(List<File> fileList) {
        List<File> resultFilesList = new ArrayList<>();
        fileList.forEach(file -> {
            if(file.isFile() && file.getName().contains(".txt") && file.length() <= 50){
                    resultFilesList.add(file);
            }
        });
        return resultFilesList;
    }
}
