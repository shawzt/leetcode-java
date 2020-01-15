package space.modx.coding;

/*
合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
*/

public class Question0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idx = m + n - 1;

        while (idx1 >= 0 && idx2 >= 0) {
            if (nums2[idx2] >= nums1[idx1]) {
                nums1[idx--] = nums2[idx2--];
            } else {
                nums1[idx--] = nums1[idx1--];
            }
        }

        while (idx1 >= 0) {
            nums1[idx--] = nums1[idx1--];
        }
        while (idx2 >= 0) {
            nums1[idx--] = nums2[idx2--];
        }
    }
}
