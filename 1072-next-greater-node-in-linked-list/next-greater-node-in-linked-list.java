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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer>list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int ans[]=new int[list.size()];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<list.size();i++){
            int curr=list.get(i);
            while(!st.isEmpty()&&list.get(st.peek())<curr){
                ans[st.pop()]=curr;
            }
            st.push(i);
        }
       return ans;
        
    }
}