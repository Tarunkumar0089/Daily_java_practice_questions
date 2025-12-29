class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int maxlen=1;
        int si=0;
        HashSet<Integer> hh = new HashSet<>();
        for(int num:nums){
            hh.add(num);
        }
        List<Integer> ll = new ArrayList<>(hh);
        Collections.sort(ll);
        for(int i=1;i<ll.size();i++){
            if(ll.get(i)-ll.get(i-1)==1){
                maxlen=Math.max(maxlen,i-si+1);
            }
            else{
                si=i;
            }
        }
        return maxlen;
    }
}