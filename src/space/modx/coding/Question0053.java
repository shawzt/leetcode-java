package space.modx.coding;

/*
最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
*/

public class Question0053 {
    // 正数增益
    public int maxSubArray_1(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            res = Math.max(sum, res);
        }

        return res;
    }

    // 直接修改原数组来记录当前位置的最大和
    // f(k) = max(num[k],f(k-1)+num[k])
    public int maxSubArray_2(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
