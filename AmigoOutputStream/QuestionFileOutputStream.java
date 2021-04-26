import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


interface AmigoOutputStream {
    void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}


/*
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream aos){
        this.original = aos;
    }

    public void flush() throws IOException{
        original.flush();
    }

    public void write(int b) throws IOException{
        original.write(b);
    }

    public void write(byte[] b) throws IOException{
        original.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException{
        original.write(b, off, len);
    }

    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!br.ready()){
            if(br.readLine().equals("Д")){
                br.close(); 
            }
        }
    }
    public static void main(String[] args) throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!br.ready()){
            if(br.readLine().equals("Д")){
                br.close(); 
            }
        }
    }
}


