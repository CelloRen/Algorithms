package sort;

// 快速排序，
public class QuickSort {
    public static void sort(Comparable[] a) {
        // 先打乱，随机洗牌
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    // 写法可以优化一下
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            // scan left
            while (Utils.less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            // scan right
            while (Utils.less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Utils.exch(a, i, j);
        }
        Utils.exch(a, lo, j);
        return j; // a[lo...j-1] <= a[j] <= a[j+1...hi]
    }
}
