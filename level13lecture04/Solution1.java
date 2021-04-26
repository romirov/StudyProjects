public class Solution1 {

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
        System.out.println(stringsLinkedList.get(4)); // 5
    }
}
class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        //напишите тут ваш код
        if (index < 0) return null; //Если индекс меньшу ноля вернуть null
        Node node = first.next;
        for(int i =0 ; i < index; i++){
            if (node == last.prev) { //если в процессе вышел за пределы списка, вернуть null
                return null;
            } else {
                node = node.next;
            }
        }
        return node.value;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
