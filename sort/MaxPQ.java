package sort;

// 堆排序
public class MaxPQ<Key extends  Comparable<Key>> {
    private Key[] pq;
    private int size = 0;

    public MaxPQ(int maxSize) {
        pq = (Key[]) new Comparable[maxSize + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key val) {
        pq[++size] = val;
        swim(size);
    }

    public Key deleteMax() {
        Key max = pq[1];
        Utils.exch(pq, 1, size--);
        pq[size + 1] = null;
        sink(1);
        return max;
    }

    // 让大的数浮起来
    private void swim(int k) {
        while (k > 1 && Utils.less(pq[k/2], pq[k])) {
            Utils.exch(pq, k/2, k);
            k /= 2;
        }
    }

    // 让小的数沉下去
    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && Utils.less(pq[j], pq[j+1])) {
                j++;
            }
            if (!Utils.less(pq[k], pq[j])) {
                break;
            }
            Utils.exch(pq, k, j);
            k = j;
        }
    }
}
