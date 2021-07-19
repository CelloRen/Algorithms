package basic;

// 用数组实现固定长度的栈
// 不足，一些异常没有处理，没有检查参数
public class FixedCapacityStackOfString {
    private String[] stack;

    private int size = 0;


    public FixedCapacityStackOfString(int capacity) {
        // 应该先判断capacity是否合法
        stack = new String[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(String item) {
        stack[size++] = item;
    }

    public String pop() {
        return stack[--size];
    }

    public String peek() {
        return stack[size - 1];
    }
}
