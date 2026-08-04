class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        HashSet<Integer>set=new HashSet<>();
        int min=nums[0];
        int max=nums[nums.length-1];
        for(int x:nums){
            set.add(x);
        }
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}