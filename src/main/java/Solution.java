import java.util.*;

class Solution {

    //    给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//    说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
    public List<Integer> majorityElement(int[] nums) {


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            Integer occurs;
            if ((occurs = map.get(nums[i])) == null) {
                if (nums.length < 3) {
                    list.add(nums[i]);
                } else {
                    map.put(nums[i], 1);
                }
            } else if (occurs + 1 > nums.length / 3) {
                list.add(nums[i]);
            } else {
                map.put(nums[i], occurs + 1);
            }
        }
        return list;
    }
}