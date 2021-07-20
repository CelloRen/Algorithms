package sort;

// 基于插入排序的思想，按照增量序列的步长，将数组分组做插入排序
// 步长为1时，即完全和插入排序相同
public class ShellSort {
    public static void sort(Comparable[] nums) {
        int len = nums.length;
        int h = 1;
        while (h < len / 3) {
            // 增量序列可以具体参考一些论文的数学证明，1 4 13 40 121 364
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // h-sort
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && Utils.less(nums[j], nums[j - h]); j -= h) {
                    // 数组中的一组 i i-h i-2*h i-3*h ...
                    Utils.exch(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
