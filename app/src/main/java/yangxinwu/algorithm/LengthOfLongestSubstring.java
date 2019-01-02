package yangxinwu.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 *
 *
 */

public class LengthOfLongestSubstring {

    // 暴力法
   private int lengthOfLongestSubstring(String s){
       int length = s.length();
       int longest = 0;
       for (int i = 0; i <length ; i++) {
           for (int j = i + 1; j <= length ; j++) {
               if (allUnique(s,i,j)) longest = Math.max(length,j - i);
           }
       }
       return longest;
   }

    private boolean allUnique(String s, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = 0; k < s.length() ; k++) {
            Character character = s.charAt(k);
            if (set.contains(character)) return false;
            set.add(character);
        }
        return true;
    }


    //窗口法
    private int windowSloution(String s){
       HashSet<Character> hashSet = new HashSet<>();
       int i = 0,j = 0,res = 0;
       int n = s.length();
       while (i < n && j < n){
           if (!hashSet.contains(s.charAt(j))){
               hashSet.add(s.charAt(j++));
               res = Math.max(res,j - i);
           }else {
               hashSet.remove(s.charAt(i++));
           }
       }
       return res;
    }





}
