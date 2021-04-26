import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel{//создаем наследника JPanel, который добавим во фрейм как любой другой виджет
    public void paintComponent(Graphics g){//Graphics g - важный графический метод. Он не вызывается самостоятельно.Система вызывает его.
        g.setColor(Color.orange);//каким цветом будем рисовать
        g.fillRect(20,50,100,100);//какую фигуру будем рисовать
    }
    public void draw(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        MyDrawPanel drawpanel = new MyDrawPanel();
        drawpanel.draw();
    }
}
