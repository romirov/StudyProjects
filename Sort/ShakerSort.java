import java.util.Scanner;
import java.util.Arrays;

/*

Сортировка пузырьком — один из самых известных алгоритмов сортировки. 
Здесь нужно последовательно сравнивать значения соседних элементов и 
менять числа местами, если предыдущее оказывается больше последующего.
Таким образом элементы с большими значениями оказываются в конце списка,
а с меньшими остаются в начале.

Шейкерная сортировка отличается от пузырьковой тем, что она двунаправленная:
алгоритм перемещается не строго слева направо,
а сначала слева направо, затем справа налево.

 */

public class ShakeSort{

    private static int[] array;
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter the length of the array to be sorted:");
            int length = scanner.nextInt();
            if(length <= 0){
                array = new int[]{9,44,1,5,3,11,99};
            }else{
                array = new int[length];
                for(int i = 0;i < array.length; i++){
                    array[i] = (int)(Math.random() * 100);
                }
            }

            System.out.println("Array befor sort: " + Arrays.toString(array));

            shakeSort();

            System.out.println("Array after sort: " + Arrays.toString(array));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void shakeSort(){
        int temporaryValue = 0;//содержит сравниваемое значение элемента массива
        int borderFistLast = array.length - 1;//граница окончания массива с конца при обходе с начала в конец
        int borderLastFist = 0;//граница окончания массива с начала при обходе с конца в начало
        while(borderFistLast != borderLastFist){
                //берем первый не обработанный элемент массива
                temporaryValue = array[borderLastFist];
                //обходим массив с начала(начального не обработанного элемента) до конца(конечного не обработанного элемента)
               for(int i = borderLastFist; i < borderFistLast; i++){
                   //сравниваем текущее значение значение элементов массива со следующем элементом в массиве
                    if(temporaryValue > array[i+1]){
                    //если текущий лидер больше следующего элемента в массиве, то продвигаем его дальше к концу массива     
                        array[i] = array[i+1];
                        array[i+1] = temporaryValue;
                    }else{
                    //если текущий лидер меньше следующего элемента в массиве, то текущим лидером становится следующий элемент в массиве
                        temporaryValue = array[i+1];
                    }
                }
                //когда доходим до конца массива и сдвигаем туда самое большое значение, то уменьшаем количество проверяемых элементов на 1
                borderFistLast--;
                System.out.println("The result of traversing the array from the first to the last element: " + Arrays.toString(array));
                //берем последний не обработанный элемент массива
                temporaryValue = array[borderFistLast];
                //обходим массив с конца(последнего не обработанного элемента) до начала(начального не обработанного элемента)
                for(int i = borderFistLast; i > borderLastFist; i--){
                   //сравниваем текущее значение значение элементов массива со следующем элеменом в массиве
                    if(temporaryValue < array[i-1]){
                    //если текущий лидер меньше следующего элемента в массиве, то продвигаем его дальше к началу массива     
                        array[i] = array[i-1];
                        array[i-1] = temporaryValue;
                    }else{
                    //если текущий лидер больше следующего элемента в массиве, то текущим лидером становится следующий элемент в массиве
                        temporaryValue = array[i-1];
                    }
                }
                //когда доходим до начала массива и сдвигаем туда самое маленькое значение, то уменьшаем количество проверяемых элементов на 1
                borderLastFist++;
                System.out.println("Result of traversing the array from last to first element: " + Arrays.toString(array));

        }
    }
}

