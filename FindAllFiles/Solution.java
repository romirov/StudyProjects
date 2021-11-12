import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> listPathOfFiles = new ArrayList<>();
        Path path = Paths.get(root);
        System.out.println(path.toString());
        try(Stream<Path> walk = Files.walk(path)){
            List<Path> list= walk.filter(Files::isRegularFile).collect(Collectors.toList());
            list.forEach(l -> listPathOfFiles.add(l.toAbsolutePath().toString()));
        }
        return listPathOfFiles;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        try{
            List<String> listPathOfFiles = getFileTree(path);
            listPathOfFiles.forEach(System.out::println);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
