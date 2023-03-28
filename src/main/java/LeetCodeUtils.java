/**
 * @Description
 * @Author chris
 * @Date 2023/3/28, 14:27
 */
public class LeetCodeUtils {
    public static ListNode createList(int... elements) {
        ListNode head = new ListNode(elements[0]);
        ListNode p = head;
        for (int i = 1; i < elements.length; ++i) {
            p.next = new ListNode(elements[i]);
            p = p.next;
        }
        return head;
    }

    @SuppressWarnings("all")
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
        } else {
            System.out.print("[");
            for (; head != null && head.next != null; head = head.next) {
                System.out.printf("%d, ", head.val);
            }
            System.out.println(String.valueOf(head.val) + ']');
        }
    }
}
