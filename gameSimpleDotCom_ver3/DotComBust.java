import java.util.*;

public class DotCom{
    private ArryList<String> locationCells;//arraylist  с ячейками, описывающими местоположение сайта
    private String name;
    public void setLocationCells(ArryList<String> loc){
        locationCells = loc
    }
}

public class DotComBust{
    /*объявляем переменные и инициализируем их*/
    private GameHelper helper = new GameHelper();
    private ArryList<DotCom> dotComsList = new ArryList<DotCom>();//создаем ArrayList только для объектов DotCom
    private int numOfGuesses = 0;

    private void setUpGame(){
        //создадим несколько сайтов,присвоим им имена и поместим в ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        /*выводим краткие инструкции пользователю*/
        System.out.println("Ваша цель - потопить три 'сайта'.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за меньшее кол-во ходов");

        for(DotCom dotComToSet : dotComsList){//повторяем с каждым объектов в списке
            ArryList<String> newLocation = helper.placeDotCom(3);//запрашиваем адрес сайта
            dotComToSet.setLocationCells(newLocation);//вызываем сеттер из объекта DotCom, чтобы передать ему местоположение сайта
        }
    }

    private void startPlaying(){
        while(!dotComList.isEmpty()){//до тех порт пока список объектов не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход");//получаем пользовательский ввод
            chechUserGuess(userGuess);//проверяем его
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess){
        numOfGuesses++;//инкрементируем кол-во попыток, которые сделал пользователь
        String result = "Мимо";//по умолчанию считаем, что пользователь промахнулся

        for(DotCom dotComToTest : dotComsList){//повторяем для всех объектов в списке
            result = dotComToTest.checkYourself(userGuess);//просим DotCom проверить ход пользователя
            if(result.equals("Попал")){
                break;
            }
            if(result.equals("Потопил")){
                dotComsList.remove(dotComToTest);//удаляем пустой объект из списка
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("Все сайты ушли ко дну");
        if(numOfGuesses <= 18){
            System.out.println("Это заняло у вас " + numOfGuesses +"попыток");
        }else

            System.out.println("Это заняло у вас слишком много " + numOfGuesses +"попыток");
    }

    public static void main(String[] args){
        DotComBust game = DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
