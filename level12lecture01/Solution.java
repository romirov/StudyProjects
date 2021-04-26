public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        //напишите тут ваш код
        if((a ==0 && b == 0) || a == Double.NaN || b == Double.NaN || (a == Double.POSITIVE_INFINITY && b == Double.POSITIVE_INFINITY) || (a == Double.POSITIVE_INFINITY && b == Double.NEGATIVE_INFINITY) || (a == Double.NEGATIVE_INFINITY && b == Double.POSITIVE_INFINITY) || (a == Double.NEGATIVE_INFINITY && b == Double.NEGATIVE_INFINITY)){
            System.out.println(Double.NaN);
        }
        else if((a > 0 && b ==0) || (a == Double.POSITIVE_INFINITY && b >= 0) || (a == Double.NEGATIVE_INFINITY && b < 0)){
            System.out.println(Double.POSITIVE_INFINITY);
        }
        else if((a < 0 && b == 0) || (a == Double.NEGATIVE_INFINITY && b >= 0) || (a == Double.POSITIVE_INFINITY && b < 0)){
            System.out.println(Double.NEGATIVE_INFINITY);
        }
        else{
            System.out.println(a/b);
        }
    }
}
