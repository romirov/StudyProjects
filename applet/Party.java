import java.awt.*;
import java.awt.event.*;

class Party{
    public void buildInvite(){
        Frame f = new Frame();
        Label l = new Label("Вечеренки у Тима");
        Button b = new Button("Ваша ставка");
        Button c = new Button("Сбросить");
        Panel p = new Panel();
        p.add(l);

    }

    public static void main(String args[]){
         Party p = new Party();
         p.buildInvite();
         System.out.println("Выполнено!");
         int x = 3;
         String str = "Knife";
         x *= 17;
         System.out.println("x равен:" + x);
         double d = Math.random();
         System.out.println("d равен:" + d);
         while(x > 12)
            x -= 1;
        System.out.println("x:"+x);
        for(int i=0; i < 7;i++){
            x+=i;
            System.out.println("x + " + i+ "равен="+x);

        }

        
    }
}
