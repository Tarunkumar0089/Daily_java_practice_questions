class Solution {
    public int smallestAbsent(int[] nums) {
        
        int sum=0;
        for(int num:nums){
            sum+=num;
                
        }
        double avg=(double) sum/nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int cand =Math.max(1,(int)Math.floor(avg)+1);
        while(set.contains(cand)){
            cand++;
        }
        return cand;
    }
}