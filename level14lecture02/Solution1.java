public class Solution1 {

    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.eat(new Food("мясо"));
        lion.eat(null);
    }
}
class Lion {

    public void eat(Food food) {
        try {
            System.out.println();
            System.out.println("ищет еду");
            System.out.println("нашел " + food.name);
            System.out.println("все съел");
        } catch (NullPointerException e) {
            System.out.println("ничего не нашел");
            return;
        }finally{
            System.out.println("лег спать" + (food == null ? " голодным" : ""));
        }
    }
}

class Food {

    String name;

    public Food(String name) {
        this.name = name;
    }
}
