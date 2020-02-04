package space.modx.coding;

/*
爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
*/

public class Question0070 {
    // T(n): O(2^n), S(n): O(n)
    public int climbStairs(int n) {
        return helper(0, n);
    }

    private int helper(int i, int target) {
        if (i > target) {
            return 0;
        }
        if (i == target) {
            return 1;
        }

        return helper(i+1, target) + helper(i+2, target);
    }

    // T(n): O(n), S(n): O(n)
    // 保存并复用计算结果
    public int climbStairs_2(int n) {
        int[] track = new int[n+1];
        return helper(0, n);
    }
    private int helper_2(int i, int target, int[] track) {
        if (i > target) {
            return 0;
        }
        if (i == target) {
            return 1;
        }
        if (track[i] > 0) {
            return track[i];
        }

        track[i] = helper_2(i+1, target, track) + helper_2(i+2, target, track);
        return track[i];
    }

    public int climbStairs_3(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
