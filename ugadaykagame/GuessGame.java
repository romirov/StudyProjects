//импортируем класс игрока
import Player.*;
/*класс игры*/
public class GuessGame{
    Player p1;// игрок 1
    Player p2;// игрок 2
    Player p3;// игрок 3
    public void startGame(){
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        int guessp1 = 0;//число, которое предлагает игрок 1
        int guessp2 = 0;//число, которое предлагает игрок 2
        int guessp3 = 0;//число, которое предлагает игрок 3

        boolean p1isRight = false;//правильность или неправильность числа, предложенного 1 игроком
        boolean p2isRight = false;//правильность или неправильность числа, предложенного 2 игроком
        boolean p3isRight = false;//правильность или неправильность числа, предложенного 3 игроком

        int targetNumber = (int) (Math.random() * 10);//загаданное число
        System.out.println("Загадываю число от 0 до 9 ...");
                                                                                                                
        while(true){
            System.out.println("Число, которое нужно угадать, - " + targetNumber);
            
            //загадывание чисел игроками
            p1.guess();
            p2.guess();
            p3.guess();
            
            //передача чисел в переменные класса
            guessp1 = p1.number;
            System.out.println("Первый игрок думает, что это число - " + guessp1);

            guessp2 = p2.number;
            System.out.println("Второй игрок думает, что это число - " + guessp2);

            guessp3 = p3.number;
            System.out.println("Третий игрок думает, что это число - " + guessp3);
                                                                                                                                                                                                                                                                                    
            //проверка результатов
            if(targetNumber == guessp1)//проверка результата для 1го игрока
                p1isRight = true;
               
            if(targetNumber == guessp2)//проверка результата для 2го игрока
                p2isRight = true;

            if(targetNumber == guessp3)//проверка результата для 3го игрока
                p3isRight = true;

            //если кто-то из игроков угадал, то выходим из цикла и заканчиваем игру
            if(p1isRight || p2isRight || p3isRight){
                System.out.println("У нас есть победитель!!!");
                System.out.println("Первый игрок победил: " + p1isRight);
                System.out.println("Второй игрок победил: " + p2isRight);
                System.out.println("Третий игрок победил: " + p3isRight);
                System.out.println("Конец игры !!!");
                break;
            }
            else{
                System.out.println("Игроки пробуют еще раз угадать!!!");
            }
        }
   }
}

