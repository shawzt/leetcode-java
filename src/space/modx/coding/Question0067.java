package space.modx.coding;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。


示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"
 

提示：
每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
*/

public class Question0067 {
    public String addBinary(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        StringBuilder builder = new StringBuilder();

        int i = len_a-1, j = len_b-1, f = 0;
        for (; i>=0 && j >= 0; i--, j--) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + f;
            f = sum / 2;
            builder.append(sum % 2);
        }

        while (i >= 0) {
            int sum = (a.charAt(i) - '0') + f;
            f = sum / 2;
            builder.append(sum % 2);

            i--;
        }

        while (j >= 0) {
            int sum = (b.charAt(j) - '0') + f;
            f = sum / 2;
            builder.append(sum % 2);

            j--;
        }

        if (f != 0) {
            builder.append(f);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Question0067 q = new Question0067();
        System.out.println(q.addBinary("11", "1"));
        System.out.println(q.addBinary("1010", "1011"));
    }
}
