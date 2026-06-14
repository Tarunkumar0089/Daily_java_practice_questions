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
    public int pairSum(ListNode head) {
        ArrayList<Integer>a1=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            a1.add(temp.val);
            temp=temp.next;
        }
           ArrayList<Integer>a2=new ArrayList<>();
           int start=0;
           int end=a1.size()-1;
           while(start<=end){
            a2.add(a1.get(start)+a1.get(end));
            start++;
            end--;
           }
           int max=0;
           for(int i=0;i<a2.size();i++){
            if(a2.get(i)>max){
                max=a2.get(i);
            }
           }
           return max;
    }
}