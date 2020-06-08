package space.modx.coding;

/*
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。
在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 

 

示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true
*/

import java.util.ArrayList;

public class Question0990 {
    private char[] p;
    private ArrayList<String> eqs;
    private ArrayList<String> notEqs;

    public boolean equationsPossible(String[] equations) {
        init(equations);

        for (String str: eqs) {
            char a = str.charAt(0) <= str.charAt(3) ? str.charAt(0) : str.charAt(3);
            char b = str.charAt(0) <= str.charAt(3) ? str.charAt(3) : str.charAt(0);

            union(a, b);
        }

        for (String str: notEqs) {
            char a = str.charAt(0) <= str.charAt(3) ? str.charAt(0) : str.charAt(3);
            char b = str.charAt(0) <= str.charAt(3) ? str.charAt(3) : str.charAt(0);
            if (notEq(a, b) == false)
                return false;
        }

        return true;
    }

    private void init(String[] equations) {
        p = new char[26];
        eqs =  new ArrayList<>();
        notEqs = new ArrayList<>();

        for (char i = 'a'; i <= 'z'; i++) {
            p[i-'a'] = i;
        }

        for (String str: equations) {
            if (str.contains("=="))
                eqs.add(str);
            else
                notEqs.add(str);
        }
    }

    private void union(char a, char b) {
        char root_a = find(p[a - 'a']);
        char root_b = find(p[b - 'a']);

        if (root_a != root_b) {
            p[root_b - 'a'] = root_a;
        }
    }

    private char find(char x) {
        if (p[x - 'a'] == x)
            return x;

        return find(p[x - 'a']);
    }

    private boolean notEq(char a, char b) {
        char root_a = find(p[a - 'a']);
        char root_b = find(p[b - 'a']);

        if (root_a != root_b) {
            return true;
        }
        return false;
    }

    // 思路: 连通分量
    public static void main(String[] args) {
        String[] case_1 = {"a==b", "b==a"};
        String[] case_2 = {"a==b", "b!=a"};
        String[] case_3 = {"c==c", "b==d", "x!=z"};
        String[] case_4 = {"a==b", "b!=c", "c==a"};
        String[] case_5 = {"b!=f", "c!=e", "f==f", "d==f", "b==f", "a==f"};
        String[] case_6 = {"a==b", "b!=c", "c==a"};
        Question0990 q = new Question0990();

        System.out.println(q.equationsPossible(case_1));
        System.out.println(q.equationsPossible(case_2));
        System.out.println(q.equationsPossible(case_3));
        System.out.println(q.equationsPossible(case_4));
        System.out.println(q.equationsPossible(case_5));
        System.out.println(q.equationsPossible(case_6));

    }
}
