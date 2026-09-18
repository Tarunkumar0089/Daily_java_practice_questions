class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        move(nums,0,n-k-1);
        move(nums,n-k,n-1);
        move(nums,0,n-1);
    }
    public void move(int[]nums,int i,int j){
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}