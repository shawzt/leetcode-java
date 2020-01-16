package space.modx.coding;

/*
计数质数
统计所有小于非负整数 n 的质数的数量。

示例:

输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
*/

import java.util.Arrays;

public class Question0204 {
    // 超时
    public int countPrimes_1(int n) {
        int count = 0;
        for (int i = 2; i < n ; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 标记排除法
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        for (int i = 2; i * i < n ; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
