import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();
    private Map<String, Boolean> containsMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if(containsMap.containsKey("partOfName")){
            if(file.getFileName().toString().contains(partOfName))
                containsMap.replace("partOfName", true);
        }
        
        if(containsMap.containsKey("partOfContent")){
            String str = new String(content);
            if(str.contains(partOfContent))
                containsMap.replace("partOfContent", true);
        }

        if(containsMap.containsKey("minSize") && containsMap.containsKey("maxSize")){
            if(content.length >= minSize && content.length <= maxSize){
                containsMap.replace("minSize", true);
                containsMap.replace("maxSize", true);
            }
        }else if(containsMap.containsKey("minSize")){
            if(content.length >= minSize)
                containsMap.replace("minSize", true);
        }else if(containsMap.containsKey("maxSize")){
            if(content.length <= maxSize)
                containsMap.replace("maxSize", true);
        }

        Set<Boolean> result = new HashSet<>(containsMap.values());
        if(!result.contains(false)){
            foundFiles.add(file);
            
        }

        for (Map.Entry<String, Boolean> entry : containsMap.entrySet()) {
            entry.setValue(false);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName){
        containsMap.put("partOfName", false);
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent){
        containsMap.put("partOfContent", false);
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize){
        containsMap.put("minSize", false);
        this.minSize = minSize;
    }
    
    public void setMaxSize(int maxSize){
        containsMap.put("maxSize", false);
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles(){
        return foundFiles;
    }
}
