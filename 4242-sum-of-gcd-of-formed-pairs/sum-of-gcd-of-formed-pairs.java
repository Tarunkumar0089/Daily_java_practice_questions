class Solution {
    public long gcdSum(int[] nums) {
        int[]pref=new int[nums.length];

        int mx=0;

        for(int i=0;i<nums.length;i++){
            mx=Math.max(mx,nums[i]);
            pref[i]=gcd(nums[i],mx);
        }
        Arrays.sort(pref);
        int l=0;
        int r=nums.length-1;
        long sum=0;

        while(l<r){
         sum+=gcd(pref[l],pref[r]);
         l++;
         r--;
        }
        return sum;
    }
    public int gcd(int a,int b){
        while (b != 0) {
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}