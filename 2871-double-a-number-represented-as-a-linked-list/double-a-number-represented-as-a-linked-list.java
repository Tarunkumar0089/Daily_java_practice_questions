
class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {

        head = reverse(head);

        int carry = 0;
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            int sum = curr.val * 2 + carry;
            curr.val = sum % 10;
            carry = sum / 10;

            prev = curr;
            curr = curr.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverse(head);
    }
}
