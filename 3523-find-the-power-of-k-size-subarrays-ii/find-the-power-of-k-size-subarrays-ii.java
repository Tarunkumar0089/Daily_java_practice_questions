class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int [] ans= new int[n-k+1];
        if(k==1) return nums;
    
        Arrays.fill(ans,-1);
        if(nums.length<k){
            return ans;
        }
        
        int cnt=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                cnt=1;
            }
            else{
                cnt++;
                if(cnt>=k){
                    ans[i-k+1]=nums[i];
                }
            }
        }
        return ans;

    }
}