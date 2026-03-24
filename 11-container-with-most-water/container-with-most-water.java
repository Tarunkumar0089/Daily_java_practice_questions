class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int ht=Math.min(height[left],height[right]);
            int width=right-left;
            int curr=ht*width;
            max=Math.max(max,curr);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}