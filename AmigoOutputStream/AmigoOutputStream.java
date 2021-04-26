import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    private FileOutputStream fos;
    public static String fileName = "C:/tmp/result.txt";
    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException{
        super(fileName);
        this.fos = fos;    
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
    public void write(byte[] b) throws IOException{
        fos.write(b);
    }
    
    public void write(byte[] b, int off, int len) throws IOException{
        fos.write(b, off, len);
    }
    
    public void write(int b) throws IOException{
        fos.write(b);
    }
    
    public void flush() throws IOException{
        fos.flush();
    }
    
    public void	close() throws IOException{
            flush();
            String str =  "JavaRush © All rights reserved.";
            write(str.getBytes());
            fos.close();
    }
}

