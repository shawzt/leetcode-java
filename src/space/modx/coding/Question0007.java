package space.modx.coding;

/*
整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
*/

public class Question0007 {
    public int reverse_1(int x) {
       int flag = x < 0 ? -1 : 1;
       x *= flag;

       long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        result *= flag;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        else
            return (int)result;
    }

    public int reverse_2(int x) {
      int result = 0;
      while (x != 0) {
          int pop = x % 10;
          x /= 10;

          if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && pop > 7))
              return 0;
          if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE/10 && pop < -8))
              return 0;

          result = result * 10 + pop;
      }

      return result;
    }
}