package sort;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int size = a.length;
        // 构建堆，这里只需构建一半，保证a[1]是最大值
        for (int k = size/2; k >= 1; k--) {
            sink(a, k, size);
        }

        // 每次将当前最大的元素a[1]和数组中后面的元素交换位置
        while (size > 1) {
            Utils.exch(a, 1, size--);
            sink(a, 1, size);
        }

    }

    // 让小的数沉下去
    private static void sink(Comparable[]a, int k, int size) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && Utils.less(a[j], a[j+1])) {
                j++;
            }
            if (!Utils.less(a[k], a[j])) {
                break;
            }
            Utils.exch(a, k, j);
            k = j;
        }
    }
}
