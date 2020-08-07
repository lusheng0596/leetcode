package test02_addTowNumbers;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 */
public class AddTwoNumbers {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了99.89%的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了65.14%的用户
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        //精妙之处，这里先实例化head，到时候while里面好写逻辑，最后返回head.next即可
        ListNode head = new ListNode(0);
        ListNode before = head;
        while (null != l1 || null != l2) {
            int l1Var = null != l1 ? l1.val : 0;
            int l2Var = null != l2 ? l2.val : 0;
            //两数相加，再加上之前一位剩余要进位的数，余数就是该位的数值，剩下的就是要进的位
            int sum = l1Var + l2Var + add;
            int result = sum % 10;
            ListNode node = new ListNode(result);
            before.next = node;
            before = node;
            add = (sum - result) / 10;
            l1 = null != l1 ? l1.next : null;
            l2 = null != l2 ? l2.next : null;
        }
        if (add != 0) {
            ListNode node = new ListNode(add);
            before.next = node;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int va) {
            val = va;
        }
    }
}
