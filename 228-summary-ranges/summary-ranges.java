class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String>list=new ArrayList<>();
        if (nums.length == 0) return list;
        int start=nums[0];

        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1 || nums[i]+1!=nums[i+1]){
              if(start==nums[i]){
                list.add(start+"");
             }
             else{
                list.add(start+"->"+nums[i]);
             }
             if(i!=nums.length-1){
                start=nums[i+1];
             }
            }
        }
        return list;
    }
}