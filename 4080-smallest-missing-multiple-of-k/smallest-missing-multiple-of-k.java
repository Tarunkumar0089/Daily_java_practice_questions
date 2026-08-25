class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int mul=1;
        while(set.contains(k*mul)){
            mul++;
        }
        return k*mul;
    }
}