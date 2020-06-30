package space.modx.coding;

/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
*/

import java.util.Arrays;

public class Question0215 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);

        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }

        return nums[0];
    }

    private void buildMaxHeap(int[] a, int size) {
        for (int i = size / 2; i >= 0; i--) {
            maxHeapify(a, i, size);
        }
    }

    private void maxHeapify(int[] a, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int max = i;

        if (l < size && a[l] > a[max]) {
            max = l;
        }

        if (r < size && a[r] > a[max]) {
            max = r;
        }

        if (max != i) {
            swap(a, i, max);
            maxHeapify(a, max, size);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public int findKthLargest_2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
