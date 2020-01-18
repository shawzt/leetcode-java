package space.modx.coding;

/*
杨辉三角形
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

import java.util.ArrayList;
import java.util.List;

public class Question0118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);

            for (int j = 1; j < i+1; j++) {
                if (j < i) {
                    row.add(data.get(i-1).get(j-1) + data.get(i-1).get(j));
                } else {
                    row.add(1);
                }
            }

            data.add(row);
        }

        return data;
    }
}
