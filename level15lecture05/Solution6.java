import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution6 {
    public static void main(String[] args){
       try(Scanner scanner = new Scanner(System.in)){
            Path sourceDirectory = Path.of("/Users/hanza/java/javarush/level15lecture05/testDir1");
            Path destinationDirectory = Path.of("/Users/hanza/java/javarush/level15lecture05/testDir2");
            
            List<Path> pathsSourceDirectory = new ArrayList<>();
            try(Stream<Path> stream = Files.walk(Path.of(sourceDirectory.toString()))){
                pathsSourceDirectory = stream.collect(Collectors.toList());
            }catch(Exception ex){
                ex.printStackTrace();
            }
            for(Path path : pathsSourceDirectory){
                try{
                    if(!path.equals(sourceDirectory)){
                        //Path result = path.subpath(sourceDirectory.getNameCount(),path.getNameCount());

                        Path result = sourceDirectory.relativize(path);
                        Files.copy(path,destinationDirectory.resolve(result));
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

