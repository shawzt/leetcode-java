package space.modx.coding;

/*
外观数列
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。



示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
*/

public class Question0038 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        int count = 1;
        String result = "1";
        while (++count <= n) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < result.length();) {
                char element = result.charAt(i);
                int j = i + 1;
                for (; j < result.length(); j++) {
                    if (result.charAt(j) != element) {
                        break;
                    }
                }
                builder = builder.append((j - i) + "" + element);
                i = j;
            }
            result = builder.toString();
        }

        return result;
    }
}
