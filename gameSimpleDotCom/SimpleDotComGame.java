import java.io.*;

class SimpleDotCom{
	int [] locationCells;//массив с рячейками расположения сайта
	int numOfHits = 0;//кол-во попаданий
	//метод для установки значений в массив расположения сайта
	public void setLocationCells(int [] locs){
		locationCells = locs;	
	}
	//проверка ввода пользовательского значения
	public String checkYourself(String stringGuess){
		int guess = Integer.parseInt(stringGuess);
		String result = "Мимо";
		for(int cell : locationCells){
			if (guess == cell){
				result = "Попал";
				numOfHits++;
				break;
			}
		}
		if(numOfHits == locationCells.length){
			result = "Потопил";
		}
		System.out.println(result);
		return result;
	}
}

class GameHelper{
    public String getUserInput(String promt){
        String inputLine = null;
        System.out.print(promt + " ");
        try{
            BufferedReader is =new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        }
        catch(IOException e){
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}

public class SimpleDotComGame{
	public static void main(String [] args){
		int numOfGuesses = 0;//кол-во ходов пользователя
		GameHelper helper = new GameHelper();//класс содержит метод для приема пользовательского ввода
		SimpleDotCom theDotCom = new SimpleDotCom();//создание объекта сайта
		int randomNum = (int) (Math.random() * 5);//начальная ячейка расположения сайта
		int[] locations = {randomNum, randomNum + 1, randomNum + 2 };//создаем масив с ячейками расположением сайта
		theDotCom.setLocationCells(locations);//передаем сайту расположение его ячеек
		boolean isAlive = true;//для проверки не закончилась ли игра
		while(isAlive == true){
			String guess = helper.getUserInput("Введите число");//получение строки вводимой пользователем
    		String result = theDotCom.checkYourself(guess);//проверяем полученные данные
	    	numOfGuesses++; //увеличиваем кол-во попыток
	        if(result.equals("Потопил")){
			    isAlive = false;
			    System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
		    }
	    }
    }
}
