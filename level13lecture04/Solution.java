public class Solution {

    public static void main(String[] args) {
        StringsLinkedList stringsLinkedList = new StringsLinkedList();
        stringsLinkedList.add("1");
        stringsLinkedList.add("2");
        stringsLinkedList.add("3");
        stringsLinkedList.add("4");
        stringsLinkedList.add("5");
        stringsLinkedList.add("6");
        stringsLinkedList.add("7");
        stringsLinkedList.add("8");
        stringsLinkedList.add("9");
        stringsLinkedList.printAll();
    }
}

class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код
        Node tekusheeZnachenieNode = new Node();
        tekusheeZnachenieNode.value = value;
        tekusheeZnachenieNode.prev = last.prev;
        if(tekusheeZnachenieNode.prev != null){
            tekusheeZnachenieNode.prev.next = tekusheeZnachenieNode;
        }
        if(first.next == null){
            first.next = tekusheeZnachenieNode;
        }
        last.prev = tekusheeZnachenieNode;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}

