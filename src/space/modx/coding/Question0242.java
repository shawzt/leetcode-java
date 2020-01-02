package space.modx.coding;

/*
有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/

import java.util.HashMap;
import java.util.Map;

public class Question0242 {
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            m.put(sc, m.getOrDefault(sc, 0) + 1);
            m.put(tc, m.getOrDefault(tc, 0) - 1);
        }

        for (Map.Entry<Character, Integer> i : m.entrySet()){
            if (i.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i)- 'a';
            count[idx]--;
            if (count[idx] < 0) {
                return false;
            }
        }

        return true;
    }
}
