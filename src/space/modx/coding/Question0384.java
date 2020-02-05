package space.modx.coding;

/*
打乱数组
打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
*/

import java.util.Random;

public class Question0384 {
    private int[] orig;
    private int[] data;
    Random rand = new Random();

    public Question0384(int[] nums) {
        // key point
        orig = nums.clone();
        data = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        data = orig;
        // key point
        orig = orig.clone();
        return orig;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < data.length; i++) {
            swapAt(i, randRange(i, data.length));
        }
        return data;
    }

    private void swapAt(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 随机返回[min, max)之间的一个索引
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */