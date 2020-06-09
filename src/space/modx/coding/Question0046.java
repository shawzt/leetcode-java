package space.modx.coding;


/*
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。


示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

提示:0 <= num < 2^31
*/

public class Question0046 {
    public int translateNum(int num) {
        if (num < 10)
            return 1;
        else if (num >= 10 && num <= 25)
            return 2;

        if (num % 100 < 10 || num % 100 > 25)
            return translateNum(num/10);
        else
            return translateNum(num/10) + translateNum(num/100);
    }

    public static void main(String[] args) {
        Question0046 q = new Question0046();
        System.out.println(q.translateNum(12258));
        System.out.println(q.translateNum(100));
        System.out.println(q.translateNum(1000006));
    }
}
