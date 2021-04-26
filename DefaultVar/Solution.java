/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

    public String str = intVar + " " + doubleVar + " " + DoubleVar + " " + booleanVar + " " + ObjectVar + " " + ExceptionVar + " " + StringVar;

    public static void main(String[] args) {
        System.out.println(new Solution().str);
        //System.out.println(doubleVar);
        //System.out.println(DoubleVar);
        //System.out.println(booleanVar);
        //System.out.println(ObjectVar);
        //System.out.println(ExceptionVar);
        //System.out.println(StringVar);

    }
}

