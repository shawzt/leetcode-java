package space.modx.coding;

/*
验证回文字符串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
*/

public class Question0125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        int head = 0, tail = s.length()-1;
        while (head <= tail) {
            if (!isValidChar(s.charAt(head))) {
                head++;
                continue;
            }
            if (!isValidChar(s.charAt(tail))) {
                tail--;
                continue;
            }

            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }

        return true;
    }

    private boolean isValidChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        } else {
            return false;
        }
    }
}
