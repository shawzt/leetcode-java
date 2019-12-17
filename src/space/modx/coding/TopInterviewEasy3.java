package space.modx.coding;

/*
旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
*/

public class TopInterviewEasy3 {
    /*
    复杂度分析

    时间复杂度：O(n)O(n) 。只遍历了每个元素一次。
    空间复杂度：O(1)O(1) 。使用了常数个额外空间。
    */
    public void rotate_1(int[] nums, int k) {
        int size = nums.length;
        if (size == 0 || k % size == 0) {
            return;
        }

        int count = 0;
        k %= size;
        for (int i = 0; count < size; i++) {
            int atIdx = i;
            int hold = nums[atIdx];
            do {
                int toIdx = (atIdx + k) % size;
                int temp = nums[toIdx];
                nums[toIdx] = hold;
                hold = temp;
                atIdx = toIdx;
                count++;
            } while (i != atIdx);
        }
    }

    public void rotate_2(int[] nums, int k) {
        int size = nums.length;
        if (size == 0 || k % size == 0) {
            return;
        }

        k %= size;
        reverse(nums, 0, size-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, size-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
