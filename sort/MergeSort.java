package sort;

// 归并排序，其思想是分治法，将数组分为AB两组，待AB两组有序之后，将AB merge
public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        // sort1(a, 0, a.length - 1);
    }

    // 自顶向下实现，递归
    private static void sort1(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort1(a, lo, mid);
        sort1(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    // 自底向上实现，循环
    private static void sort2(Comparable[] a) {
        int len = a.length;
        for (int sz = 1; sz < len; sz = 2 * sz) {
            for (int lo = 0; lo < len - sz; lo += 2 * sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, len - 1));
            }
        }
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // merge a[lo...mid] with a[mid+1...hi]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to a
        for (int k = lo; k <= hi; k++) {
            if (i > mid) { // lo-mid的已经排完，将j的依次append即可
                a[k] = aux[j++];
            } else if (j > hi) { // mid+1-hi的已经排完，将i的依次append即可
                a[k] = aux[i++];
            } else { // 选aux[i], aux[j]中较小的，append
                a[k] = Utils.less(aux[i], aux[j]) ? aux[i++] : aux[j++];
            }
        }
    }
}
