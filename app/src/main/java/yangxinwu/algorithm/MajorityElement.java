package yangxinwu.algorithm;


//
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//         
//
//        示例 1:
//
//        输入: [3,2,3]
//        输出: 3
//        示例 2:
//
//        输入: [2,2,1,1,1,2,2]
//        输出: 2
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/majority-element
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    private Map<Integer, Integer> countNumbers(int[] numbers){

        Map<Integer, Integer> map = new HashMap<>();

        for (int i: numbers) {
            if (map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            }else {
                map.put(i,1);
            }
        }
        return map;
    }


    public int majorityElement(int[] numbers){
        Map<Integer, Integer> map = countNumbers(numbers);
        int n = numbers.length >> 1;
        for (Map.Entry<Integer,Integer> element:map.entrySet()) {
            if (element.getValue() > n){
                return element.getKey();
            }
        }
        return -1;
    }
    

}
