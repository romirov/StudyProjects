import java.util.Arrays;
public class Solution {

    public static void main(String[] args) {
        CustomStringArrayList arrayList = new CustomStringArrayList();
        for(int i = 0; i < 25; i++) {
            arrayList.add("count" + i);
        }

    }
}

class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
            System.out.println(capacity);
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишите тут ваш код
        String[] temp = Arrays.copyOfRange(elements, 0, elements.length);
        capacity = (int)((double) capacity * 1.5);
        elements = new String[capacity];
        for(int i = 0; i < temp.length; i++){
            elements[i] = temp[i];
        }
    }

}

