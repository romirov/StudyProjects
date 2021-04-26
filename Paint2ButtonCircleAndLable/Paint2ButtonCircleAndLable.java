package Paint2ButtonCircleAndLable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *Класс для рисования круга с градиентом во фрейме
 */
class MyPaintCircle extends JPanel{
    //метод для получения градиента и отрисовки круга
    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        //устанавливаем начальную границу цвета для градиента 
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        //устанавливаем конечную границу цвета для градиента 
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);

        //устанавливаем градиент
        GradientPaint gradient = new GradientPaint(70,70, startColor, 150, 150, endColor);
        //утанавливаем градиент для кисти. которой будем рисовать круг
        g2D.setPaint(gradient);
        g2D.fillOval(70,70,100,100);
    }
}
/**
 * Класс, рисующий основной фрейм
 * @param frame основной и единственный фрейм с кнопкой и кругом
 */
class MyPaintFrame{
    private JFrame frame;
    private JLabel label;

    //метод отрисовки фрейма с кнопкой и кругом
    public void goDrawFrame(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //создаем кнопку для изменения цвета круга
        JButton colorButton = new JButton("Change color");
        //создаем кнопку для изменения текста метки
        JButton labelButton = new JButton("Change label");
        //устанавливаем для кнопок слушателя ее событий
        colorButton.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());

        //создаем метку
        label = new JLabel("I`am new label");
        
        //создаем круг с градиентом
        MyPaintCircle pCircle = new MyPaintCircle();
        
        //добавляем кнопку для изменения градиента во фрейм
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        //добавляем круг во фрейм
        frame.getContentPane().add(BorderLayout.CENTER, pCircle);
        //добавлем метку во фрейм
        frame.getContentPane().add(BorderLayout.WEST, label);
        //добавляем кнопку для изменения текста метки
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        
        //устанавливаем размер фрейма и делаем его видимым
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    //создаем внутренний класс -слушатель для кнопки colorButton, метод для получения обратного вызова и перерисовки фрейма при получении события при нажатии кнопки
    class ColorListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.repaint();
        }
    }

    class LabelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            label.setText("Ouch!!!");
        }

    }
}
class Paint2ButtonCircleAndLable{
    public static void main(String[] args){
        MyPaintFrame pFrame = new MyPaintFrame();
        pFrame.goDrawFrame();
    }
}
