package basic;

// 二分法
public class BinarySearch {
    // 循环实现
    public int rank(int key, int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < nums[mid]) {
                hi = mid - 1;
            } else if (key > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 递归实现
    public int rankForRecursion(int key, int[] nums) {
        return rank(key, nums, 0, nums.length - 1);
    }

    private int rank(int key, int[] nums, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < nums[mid]) {
            return rank(key, nums, lo, mid - 1);
        } else if (key > nums[mid]) {
            return rank(key, nums, lo + 1, mid);
        } else {
            return mid;
        }
    }
}
