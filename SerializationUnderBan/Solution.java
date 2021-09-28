
import java.io.*;



/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws IOException{
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
            throw new NotSerializableException();
        }
    }


    public static void main(String[] args) {
        
        try{
            FileOutputStream fileOutput = new FileOutputStream("test");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

            SubSolution subSolution = new SubSolution();
            outputStream.writeObject(subSolution);

            fileOutput.close();
            outputStream.close();

            //load
            FileInputStream fiStream = new FileInputStream("test");
            ObjectInputStream objectStream = new ObjectInputStream(fiStream);

            SubSolution loadedObject = (SubSolution) objectStream.readObject();

            fiStream.close();
            objectStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
