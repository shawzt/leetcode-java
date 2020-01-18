package space.modx.coding;

/*
3的幂
给定一个整数，写一个函数来判断它是否是 3 的幂次方。

示例 1:

输入: 27
输出: true
示例 2:

输入: 0
输出: false
示例 3:

输入: 9
输出: true
示例 4:

输入: 45
输出: false
进阶：
你能不使用循环或者递归来完成本题吗？
*/

public class Question0326 {
    // 超时
    public boolean isPowerOfThree_1(int n) {
        if (n == 1) {
            return true;
        }

        int target = 3;
        while (n >= target) {
            if (n == target) {
                return true;
            }

            target = target * 3;
        }
        return false;
    }

    // n = b^x = b *b * b * b ... * b
    public boolean isPowerOfThree_2(int n) {
       if (n < 1) {
           return false;
       }

       while (n % 3 == 0) {
           n = n / 3;
       }

       return n == 1;
    }

    // 数字转换为以3为底的基数 ，并检查它是否为前导1，后跟所有0
    public boolean isPowerOfThree_3(int n) {
        return Integer.toString(n , 3).matches("^10*$");
    }
}
