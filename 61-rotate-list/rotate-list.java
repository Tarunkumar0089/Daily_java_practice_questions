/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k==0){
            return head;
        }
        ListNode temp=head;
        int n=0;
        while(temp.next !=null){
            temp=temp.next;
            n++;
        }
        n++;
        temp.next=head;

        k=k%n;
        if(k==0)
        {
            temp.next=null;
            return head;
        }
        for(int i=0; i<(n-k); i++){
            temp=temp.next;
        }
        ListNode newHead= temp.next;
        temp.next=null;
        return newHead;
    }
}