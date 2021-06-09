
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object object = objectStream.readObject();
            if(object instanceof A){
                return (A)object;
            }
        }catch(Exception e){
            System.out.println("Deserialization error");
            return null;
        }
        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
