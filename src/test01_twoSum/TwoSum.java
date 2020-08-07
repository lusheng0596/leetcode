package test01_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * =======================================================================================================
 * 官方给出了3种解法
 *
 * 具体可以查看
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 *
 * 1、暴力解决，双层循环，相加得到目标值则返回
 * 复杂度分析：
 *
 * 时间复杂度：O(n^2)
 * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)O(n) 的时间。因此时间复杂度为 O(n^2)。
 *
 * 空间复杂度：O(1)。
 *
 * 暴力这个方法，在数据量少的情况下，还可以，因为hashmap也是有额外操作
 * =======================================================================================================
 *
 * 我的解题思路
 * 1、循环遍历，取得目标值与现值的差-->diff
 * 2、维护一个map，存放之前的值与下标，看diff是不是在map里面。在的话，就说明现值与map取的值加起来为target，直接返回。
 *    如果没有的话，把现值放进去，后续遍历在取。
 * 算法复杂度 o（n）
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int a = 0;
        int b = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        //一层循环
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            int kk = target - a;
            //取得得到目标值需要的加数
            if (null != map.get(kk)) {
                //如果加数在map里面，直接返回加数的下标
                result[0] = map.get(kk);
                result[1] = i;
                return result;
            }
            //如果加数不在的话，那把本次循环的数加进去
            map.put(a, i);
        }
        return result;
    }
}
