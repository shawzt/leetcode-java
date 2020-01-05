package space.modx.coding;

/*
实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
*/

public class Question0028 {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int n = needle.length();

        if (n == 0) {
            return 0;
        }
        if (len < n) {
            return -1;
        }

        int idx = 0;
        int head = 0;
        while (head < len){
            if (haystack.charAt(head) == needle.charAt(idx)) {
                head++;
                idx++;
            } else {
                head = head - idx + 1;
                idx = 0;
            }

            if (idx == n) {
                return head - idx;
            }
        }

        return -1;
    }
}
