package yangxinwu.algorithm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

/**
 *  https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true
 */

public class Solution {
    private HashMap<Character,Character> mMappings = new HashMap<>();

    public Solution(){
        this.mMappings.put(')','(');
        this.mMappings.put('}','{');
        this.mMappings.put(']', '[');
    }

    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (mMappings.containsKey(c)){
              Character popChar = stack.isEmpty() ? '#' : stack.pop();
                System.out.println("now value =   " + c);
                System.out.println("pop value =   " + popChar);
              if (!popChar.equals(mMappings.get(c))){
                  return false;
              }
            }else {
                System.out.println("---------push value =   " + c);
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) throws IOException {
            boolean ret = new Solution().isValid("([)][][]()()(){[[]]})");
            System.out.print(ret);
    }

    /*
    *
    * 解题思路：利用栈的特性；
    *
    *算法
    1.初始化栈 S。
    2.一次处理表达式的每个括号。
    3.如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
    4.如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
    5.如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
    *
    *
    * 复杂度：
    * 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1)O(1) 的推入和弹出操作。
      空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。例如 ((((((((((。
    *
    * 知识点：
    *  栈： Stack<Character> stack = new Stack<>();
    *  stack.pop(); stack.push();
    *
    *
    *
    * */


}
