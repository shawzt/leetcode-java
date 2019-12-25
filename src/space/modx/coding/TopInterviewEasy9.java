package space.modx.coding;

/*
两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

import java.util.HashMap;

public class TopInterviewEasy9 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (!m.containsKey(other)) {
                m.put(nums[i], i);
            } else {
                result[0] = m.get(other);
                result[1] = i;
            }
        }

        return result;
    }
}
