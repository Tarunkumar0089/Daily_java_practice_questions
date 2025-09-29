class Solution {
    public boolean isValid(int a, int b,int c){
        return (a+b>c);
    }
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1;i>=2;i--){
            int a = nums[i-2];
            int b = nums[i-1];
            int c = nums[i];
            if(isValid(a,b,c)){
                return a+b+c;
            }
        }
        return 0;
    }
}