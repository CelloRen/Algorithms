package basic;

// 用链表实现队列
public class QueueWithLinkedList<Item> {
    private Node first; // head, 进队
    private Node last; // tail，出队

    private int size;

    private class Node{
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null; // or size == 0
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node(item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return item;
    }

}
