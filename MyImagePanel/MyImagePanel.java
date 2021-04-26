package MyImagePanel;
import javax.swing.*;
import java.awt.*;
/**
 * Создаем класс для отрисовки во фрейме рисунка
 */

class MyImagePanel extends JPanel{//создаем подкласс JPanel, который будет добавляться во фрейм как виджет
    /**
     * метод, вставляющий рисунок во фрейм, вызывается системой
     */
    public void paintComponent(Graphics g){
        /**
         * получаем картинку#
         * Если не указать полный путь к файлу с картинкой, то файл с картинкой будет#
         * искаться в базовом каталоге данный класс помещен в пакет MyImagePanel#
         * базовым каталогом для которого является /home/hanza/java
         */
        Image image = new ImageIcon("/home/hanza/java/MyImagePanel/java.jpg").getImage();//получаем картинку. Если не указать полный путь к файлу с картинкой, то файл с картинкой будет искаться в базовом каталоге данный класс помещен в пакет MyImagePanel. базовым каталогом для которого является /home/hanza/java
        g.drawImage(image,3,4,this);//координаты для левого верхнего угла: 3 - отступ в 3 пикселя от левого края панели, 4 - отступ в 4 пикселя от верхнего края панели
//        g.fillRect(20,50,700,700);
    }
    /**
     * метод, добавляющий нашу картинку во фрейм
     */
    public void draw(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);//добавляем наш подкласс во фрейм
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
    /**
     * основной метод: main
     */
    public static void main(String[] args){
        MyImagePanel myImagePanel = new MyImagePanel();
        myImagePanel.draw();
    }

}
