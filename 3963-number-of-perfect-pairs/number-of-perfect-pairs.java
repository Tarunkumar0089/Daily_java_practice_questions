class Solution {
    public long perfectPairs(int[] nums) {
        long[] ans=new long[nums.length];
        for(int i=0;i<nums.length;i++){
             ans[i]=Math.abs((long)nums[i]);
        }
        Arrays.sort(ans);
        int n=ans.length;
        long cnt=0;
        int j=0;
        for(int i=0;i<ans.length;i++){
            while(j<n && ans[j]<=2*ans[i]){
                j++;
            }
            cnt+=(j-i-1);
        }
        return cnt;
    }
}