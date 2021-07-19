package basic;

// 用链表实现栈
public class StackWithLinkedList<Item> {
    private Node first; // top of the stack

    private int size;

    private class Node{
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null; // or size == 0
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        size++;
    }

    public Item pop() {
        Node oldFrist = first;
        first = first.next;
        size--;
        return oldFrist.item;
    }

    public Item peek() {
        return first.item;
    }
}
