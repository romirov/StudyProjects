import java.util.Scanner;
import java.util.Arrays;

/*
 
Сортировка расчёской — улучшение сортировки пузырьком. 
Её идея состоит в том, чтобы «устранить» элементы с небольшими значения в конце массива,
которые замедляют работу алгоритма. Если при пузырьковой и шейкерной сортировках 
при переборе массива сравниваются соседние элементы,
то при «расчёсывании» сначала берётся достаточно большое расстояние
между сравниваемыми значениями, а потом оно сужается вплоть до минимального.

Первоначальный разрыв нужно выбирать не случайным образом,
а с учётом специальной величины — фактора уменьшения,
оптимальное значение которого равно 1,247.
Сначала расстояние между элементами будет равняться размеру массива,поделённому на 1,247;
на каждом последующем шаге расстояние будет снова делиться на фактор уменьшения — 
и так до окончания работы алгоритма.

*/
public class CombSort{
        
    private static int[] array;
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter the length of the array to be sorted:");
            int length = scanner.nextInt();
            if(length <= 0){
                System.out.println("Invalid length entered. Therefore, the default array will be used.");
                array = new int[]{9,44,1,5,3,11,99};
            }else{
                array = new int[length];
                for(int i = 0;i < array.length; i++){
                    array[i] = (int)(Math.random() * 100);
                }
            }

            System.out.println("Array befor sort: " + Arrays.toString(array));
            
            combSort();

            System.out.println("Array after sort: " + Arrays.toString(array));

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private static void combSort(){
        //содержит сравниваемое значение элемента массива
        int temporaryValue = 0;
        //первоначальная дистанция между сравниваемыми элементами
        int distanceBetweenElements = array.length;
        while(distanceBetweenElements > 2){
        //устанавливаем первоначальную дистанцию между сравниваемыми элементами
            distanceBetweenElements = (int)(Math.round(distanceBetweenElements/1.247));
            System.out.println("Distance between array elements: " + distanceBetweenElements);
            //проход массива
            for(int i = 0; i < array.length; i++){
                //крайний элемент из двух не должен выходить за пределы массива
                if((i + distanceBetweenElements) < array.length){
                    //сравниваем пару элементов, если один болше другого, то меняем их местами
                   if(array[i] > array[i + distanceBetweenElements]){
                        temporaryValue = array[i];
                        array[i] = array[i + distanceBetweenElements];
                        array[i + distanceBetweenElements] = temporaryValue;
                   }
                }else break;
            }
            System.out.println("The intermediate value of the sorted array: " + Arrays.toString(array));
        }
    }
}

