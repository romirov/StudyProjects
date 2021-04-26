import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution5 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of("/Users/hanza/java/javarush/level15lecture05/testDir1");
        Path targetDirectory = Path.of("/Users/hanza/java/javarush/level15lecture05/testDir2");

        //Files.walk(sourceDirectory).forEach(path -> {
            try(DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) {
                for (Path pathDS : files){
                    if(!Files.isDirectory(pathDS)){
                        if(Files.isRegularFile(pathDS)){
                            Files.copy(pathDS, targetDirectory.resolve(pathDS.getFileName()));
                        } 
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        //});
    }
}

