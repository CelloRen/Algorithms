package sort;

// 插入排序, 保证左侧遍历过的数组是有序的，每次将对应的数字插入到它应该在的地方
public class InsertionSort {
    public static void sort(Comparable[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0 && Utils.less(nums[j], nums[j - 1]); j--) {
                // 目前的数字比左侧的小，交换位置，然后再和左侧的比
                Utils.exch(nums, j, j - 1);
            }
        }
    }
}
