package space.modx.coding;
/*
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1)

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]

示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

提示：
1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
*/

import java.util.Stack;

public class CQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public CQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void appendTail(int value) {
        first.push(value);
    }

    public int deleteHead() {
        if (first.empty())
            return -1;

        stackOut();
        int val = second.pop();
        stackIn();
        return val;
    }

    private void stackOut() {
        while (!first.empty()) {
            second.push(first.pop());
        }
    }

    private void stackIn() {
        while (!second.empty()) {
            first.push(second.pop());
        }
    }
}

/*
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */