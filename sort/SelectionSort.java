package sort;

// 选择排序, 每次选择最小的放到左边
public class SelectionSort {
    public static void sort(Comparable[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                // 找到i-len之间最小的，移到i处
                if (Utils.less(nums[j], nums[minIndex])) {
                    minIndex = j;
                }
            }
            Utils.exch(nums, i, minIndex);
        }
    }
}
