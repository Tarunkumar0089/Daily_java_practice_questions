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
        long[] prefix = new long[n];
        prefix[0]=nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i]=prefix[i-1]+nums[i];
        }
        long max=0;
        for(int i=0;i<nums.length;i++){
         long l=left[i]<0?0:prefix[left[i]]; 
         long r=prefix[right[i]-1]; 
         max=Math.max(max,(long)nums[i]*(r-l));
        }
        return (int)(max%mod);
    }
}