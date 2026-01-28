class Solution {
    public int maxResult(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, Integer.MIN_VALUE);
    //     return sol(0, k, dp, nums);
    // }
    // public int sol(int i, int k, int[] dp, int[] nums) {
    //     if (i>= nums.length) return Integer.MIN_VALUE;
    //     if (i== nums.length - 1) return nums[i];
    //     if (dp[i] != Integer.MIN_VALUE) return dp[i];
    //     int max = Integer.MIN_VALUE;
    //     for (int j = 1; j <= k && i + j < nums.length; j++) {
    //         max = Math.max(max, nums[i] + sol(i + j, k, dp, nums));
    //     }
    //     return dp[i] = max;
    Deque<Integer>dq=new ArrayDeque<>();
    dq.add(0);
    for(int i=1;i<nums.length;i++){
        if(dq.peekFirst()+k<i){
            dq.pollFirst();
        }
        nums[i]+=nums[dq.peekFirst()];
        while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
            dq.pollLast();
        }
        dq.addLast(i);

    }
    return nums[nums.length-1];
    }
}
