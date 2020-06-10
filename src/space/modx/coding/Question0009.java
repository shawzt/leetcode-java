package space.modx.coding;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:
你能不将整数转为字符串来解决这个问题吗？
*/

public class Question0009 {
    public boolean isPalindrome(int x) {
        String str = x + "";
        int h = 0;
        int t = str.length() - 1;

        while (h <= t) {
            if (str.charAt(h++) != str.charAt(t--))
                return false;
        }

        return true;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0)
            return false;

        int tmp = x;
        int toBe = 0;
        while (tmp != 0) {
            toBe = toBe * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return toBe == x;
    }
}
