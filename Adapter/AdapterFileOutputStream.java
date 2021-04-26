import java.io.FileOutputStream;
import java.io.IOException;

/* 
Адаптер
*/

interface AmigoStringWriter {
    void flush() throws IOException;

    void writeString(String s) throws IOException;

    void close() throws IOException;
}


public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fos;
    
    public AdapterFileOutputStream(FileOutputStream fos){
        this.fos = fos;
    }
    
    public void flush() throws IOException{
        this.fos.flush();
    }
    
    public void writeString(String str) throws IOException{
        this.fos.write(str.getBytes());
    }
    
    public void close() throws IOException{
        this.fos.close();
    }

    public static void main(String[] args) {

    }


}

