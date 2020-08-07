package test03_lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * #################################
 *  官方，滑动窗口
 *
 */
public class LengthOfLongestSubstring {
    /**
     * version1
     * @param s
     * @return
     *
     * 执行情况
     * 执行用时：11 ms, 在所有 Java 提交中击败了32.10%的用户
     *
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了19.12%的用户
     */
    public int lengthOfLongestSubstring_v1(String s) {
        /**
         * 思路：
         * 维护一个可变的字符，记录没有重复值的内容，一旦遇到相同的，计算max与截断的长度，
         * 如果最后还有剩余的内容，则最后在计算max与剩余内容的长度
         *
         */
        int max = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            String charString = s.substring(i, i + 1);
            if(temp.contains(charString)){
                int index = temp.indexOf(charString);
                max = max>temp.length()?max:temp.length();
                temp = temp.substring(index+1);
            }
            temp+=charString;
        }
        if(temp.length()>0){
            max = max>temp.length()?max:temp.length();
        }
        return max;
    }

    /**
     * 官方版本（滑动窗口+set）
     *
     * 复杂度分析
     *
     * 时间复杂度：O(N)O(N)，其中 NN 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     *
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)，其中 \SigmaΣ 表示字符集（即字符串中可以出现的字符），|\Sigma|∣Σ∣ 表示字符集的大小。
     * 在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0, 128)[0,128) 内的字符，即 |\Sigma| = 128∣Σ∣=128。
     * 我们需要用到哈希集合来存储出现过的字符，而字符最多有 |\Sigma|∣Σ∣ 个，因此空间复杂度为 O(|\Sigma|)O(∣Σ∣)。
     *
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
