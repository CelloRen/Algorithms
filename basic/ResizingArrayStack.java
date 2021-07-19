package basic;

import java.util.Iterator;

// 用数组实现非固定长度的栈, 实现了范型
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] stack;

    private int size = 0;


    public ResizingArrayStack(int capacity) {
        // 应该先判断capacity是否合法
        stack = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        if (size >= stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    public Item pop() {
        Item item =  stack[--size];
        stack[size] = null;
        if (size > 0 && size <= stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public Item peek() {
        return stack[size - 1];
    }

    private void resize(int maxSize) {
        Item[] temp = (Item[]) new Object[maxSize];
        // if size = 4, maxSize = 8, it's ok
        // if size = 4, maxSize 2, it's bad
        for (int i = 0; i < Math.min(size, maxSize); i++) { // 书中是size, 感觉有问题
            temp[i] = stack[i];
        }

        stack = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }
    }
}
