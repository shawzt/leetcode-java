package space.modx.coding;
/*
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
返回一对观光景点能取得的最高分。

 

示例：
输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 

提示：
2 <= A.length <= 50000
1 <= A[i] <= 1000
*/

/*
* 拆分成 A[i]+i 和 A[j]-j 两部分，这样对于统计景点 j答案的时候，由于A[j]−j 是固定不变的
* 因此最大化 A[i]+i+A[j]-j的值其实就等价于求 [0,j-1]中 A[i]+i的最大值 mx，
* 景点 j的答案即为 mx+A[j]-j。而 mx的值我们只要从前往后枚举 jj 的时候同时维护即可
*/

public class Question1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int result = 0;
        int mx = A[0] + 0;

        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, mx + A[i] - i);
            mx = Math.max(mx, A[i] + i);
        }

        return result;
    }
}
