package basic;

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sizeOfComponentRoot; // 确保不会树退化成链表
    private int count;


    public WeightedQuickUnionUF(int count) {
        this.count = count;
        id = new int[count];
        sizeOfComponentRoot = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sizeOfComponentRoot[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        if (sizeOfComponentRoot[pRoot] < sizeOfComponentRoot[qRoot]) {
            id[pRoot] = id[qRoot];
            sizeOfComponentRoot[pRoot] += sizeOfComponentRoot[qRoot];
        } else {
            id[qRoot] = id[pRoot];
            sizeOfComponentRoot[qRoot] += sizeOfComponentRoot[pRoot];
        }

        count--;
    }

}
