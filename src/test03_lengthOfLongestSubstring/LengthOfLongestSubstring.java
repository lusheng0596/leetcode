package test03_lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

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
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        int cdd = lengthOfLongestSubstring_v2("abcabcbb");
        System.out.println(cdd);
    }
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
     * 版本2
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_v2(String s) {
        /**
         * 思路：
         *
         *
         */
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)){
                Iterator<Character> iterator = set.iterator();
                int remove = 1;
                while(iterator.hasNext()){
                    Character character = iterator.next();
                    if(character.equals(c)){
                        max = max>remove?max:remove;
                        iterator.remove();
                    }else{
                        iterator.remove();
                    }
                    remove++;
                }
            }
            set.add(c);
        }
        max = max>set.size()?max:set.size();
        return max;
    }
}
