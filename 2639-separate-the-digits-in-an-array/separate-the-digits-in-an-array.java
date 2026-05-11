class Solution {
     ArrayList<Integer>arr=new ArrayList<>();
    public int[] separateDigits(int[] nums) {
        for(int i=0;i<nums.length;i++){
               sol(Integer.toString(nums[i]));
        }
       int[]ans=new int[arr.size()];
       for(int i=0;i<ans.length;i++){
        ans[i]=arr.get(i);
       }
       return ans;
    }
    public void sol(String str){
        for(int i=0;i<str.length();i++){
            arr.add(str.charAt(i)-'0');
        }
    }
}