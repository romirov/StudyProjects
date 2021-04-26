/*
При сортировке вставками массив постепенно перебирается слева направо. При этом каждый последующий элемент размещается так, чтобы он оказался между ближайшими элементами с минимальным и максимальным значением.
*/

import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort{
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

             insertionSort(); 
            
             System.out.println("Array after sort: " + Arrays.toString(array));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void insertionSort(){
        //объявляем и инициализируем переменную для временного хранения значения элемента массива
        int temp = 0;
        //проходим массив от начального до конечного элемента
        for(int i = 0; i < array.length; i++){
            //берем текущий элемент массива и сравниваем с предыдущим, если он меньше, то сдвигаем его на место предыдущего, а предыдущий ставим на место текущего
            for(int j = i; j > 0; j-- ){
                    if(array[j] < array[j-1]){
                        temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }else break;
            }
             System.out.println("Intermediate sorted array: " + Arrays.toString(array));
        }
    }
}

