class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0;
        int c2=0;
        int val1=-1;
        int val2=-1;
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val1){
                c1++;
            }else if(nums[i]==val2){
                c2++;
            }else{
                if(c1==0){
                    c1++;
                    val1=nums[i];
                }else if(c2==0){
                    c2++;
                    val2=nums[i];
                }
                else{
                    c1--;
                    c2--;
                }
            }
        }
        c1=0;
        c2=0;
        for(int num:nums){
            if(num==val1){
                c1++;
            }else if(num==val2){
                c2++;
            }
        }
        if(c1>nums.length/3)ll.add(val1);
        if(c2>nums.length/3)ll.add(val2);
        return ll;
    }
}