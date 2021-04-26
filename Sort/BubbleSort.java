import java.util.Scanner; 
import java.util.Arrays;

//Сортировка пузырьком. 
//Здесь нужно последовательно сравнивать значения соседних элементов и менять числа местами, если предыдущее оказывается больше последующего. 
//Таким образом элементы с большими значениями оказываются в конце списка, а с меньшими остаются в начале.

public class BubbleSort{
    private static int[] array;
    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
            System.out.print("Enter the length of the array to sort: ");
            //получем длину массива для сортировки
            int length = input.nextInt();
            //проверяем валидность длинны массива
            if(length <= 0){
                System.out.println("Array length must be greater than zero. Try again.");
                System.exit(0);
            }
            //создаем и инициализируем массив
            array = new int[length];
            //заполняем массив
            for(int i = 0; i < array.length; i++){
                array[i] = (int)(Math.random() * 100);
            }
            //выводим массив без сортировки
            System.out.println(Arrays.toString(array));

            //вариант пузырьковой сортировки
            bubbleSort();
                
            //выводим отсортированный массив
            System.out.println(Arrays.toString(array));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void bubbleSort(){
        //временная переменная для хранения промежуточных значений массива
        int temp = 0;
        //длина массива массива, которая должна уменьшаться при каждом полном его прохождении
        int arrayLength = array.length - 1;
        while(arrayLength > 0 ){//пока счетчик прохождения массива  меньше его длинны
            //передаем временной переменной значение 0го элемента в массиве
            temp = array[0];
            for(int i = 0; i < arrayLength; i++){//пробегаем массив
                if(temp > array[i + 1]){//если значение временной переменной(текущее значение iго элемента в массиве) > i+1 го , то меняем их местами и обнуляем счетсчик
                       array[i] = array[i + 1];
                       array[i + 1] = temp;
                }else{//если значение iго элемента в массиве <= i+1 го,то значением врменной переменной становится значение i+1 элемента в массиве и счетчик прохождения массива увеличивается
                    temp = array[i + 1];
                }
            }
            arrayLength--;
            System.out.println(Arrays.toString(array));
        }
    }
}

