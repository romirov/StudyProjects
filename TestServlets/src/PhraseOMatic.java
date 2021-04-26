public class PhraseOMatic{
  public static String makePhrase(){
    //создаем три набора слов на выбор
    String[] worldListOne = {"круглосуточный", "трех-звенный", "30000-футовый","взаимный"};
    String[] worldListTwo = {"уполномоченный", "трудный", "чистый продукт","ориентированный"};
    String[] worldListThree = {"процесс","пункт разгрузки","выход из положения","тип структуры"};

    //вычисляем кол-во слов в массивах
    int oneLength = worldListOne.length;
    int twoLength = worldListTwo.length;
    int threeLength = worldListThree.length;

    //генерируем три случайных числа для выбора случайного слова из каждого списка
    int randr1 = (int) (Math.random() * oneLength);
    int randr2 = (int) (Math.random() * twoLength);
    int randr3 = (int) (Math.random() * threeLength);

    //строим фразу
    String phrase = worldListOne[randr1] + " " + worldListTwo[randr2] + " " + worldListThree[randr3];

    //возращаем ее
    return ("Все, что нам нужно, - это" + phrase);
  }
}
