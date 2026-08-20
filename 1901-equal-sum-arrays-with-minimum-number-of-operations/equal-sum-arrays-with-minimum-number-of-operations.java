class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n*6<m || m*6<n) return -1;
        int sum1 = 0, sum2=0;
        for(int num : nums1){
            sum1 += num;
        }
        for(int num : nums2){
            sum2 += num;
        }
        if(sum1>sum2){
            return minOperations(nums2, nums1);
        }
        int opr = 0;
        int freq[] = new int[6];
        int diff = sum2-sum1;

        for(int num : nums1){
            freq[6-num]++;
        }
        for(int num : nums2){
            freq[num-1]++;
        }
        for(int i=5; i>=1; i--){
            while(freq[i]>0 && diff>0){
                diff -= i;
                freq[i]--;
                opr++;
            }
        }
        return opr;

    }
}