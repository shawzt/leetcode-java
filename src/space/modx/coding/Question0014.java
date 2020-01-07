package space.modx.coding;

/*
最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
*/

public class Question0014 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String str1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            str1 = lcp(str1, strs[i]);
            if (str1 == "") {
                return "";
            }
        }

        return str1;
    }

    private String lcp(String str1, String str2) {
        StringBuilder builder = new StringBuilder();
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                builder.append(str1.charAt(i));
            } else {
                break;
            }
        }

        return builder.toString();
    }
}
