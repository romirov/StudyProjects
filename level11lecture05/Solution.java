public class Solution {
    public static int salary;

    public static void add(int increase) {
        int intA = Solution.salary;
        salary += increase;
    }
    public static void main(String[] args) {
        add(100500);
        System.out.println(salary);
    }
}
