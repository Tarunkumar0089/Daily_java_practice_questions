class Solution {
    public int maxSumMinProduct(int[] nums) {
        Stack<int[]>st1=new Stack<>();
        Stack<int[]>st2=new Stack<>();
        int n=nums.length;
        int mod=1000000007;
        
        int [] left=new int[nums.length];
        int right[] =new int[nums.length];
        for(int i=0;i<n;i++){
           while(!st1.isEmpty()&& nums[i]<=st1.peek()[0]){
            st1.pop();
           }
           left[i]=st1.isEmpty()?-1:st1.peek()[1];
           st1.push(new int[]{nums[i],i});
        }
        for(int i=n-1;i>=0;i--){
           while(!st2.isEmpty()&& nums[i]<=st2.peek()[0]){
            st2.pop();
           }
           right[i]=st2.isEmpty()?n:st2.peek()[1];
           st2.push(new int[]{nums[i],i});
        } 
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long max=0;
        for(int i=0;i<nums.length;i++){
         long sum=prefix[right[i]]-prefix[left[i]+1];
         max=Math.max(max,sum*nums[i]);
        }
        return (int)(max%mod);
    }
}