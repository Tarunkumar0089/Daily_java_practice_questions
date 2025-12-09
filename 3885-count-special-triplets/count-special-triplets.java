class Solution {
    static int M = (int)1e9 + 7;
    public int specialTriplets(int[] nums) {
        HashMap<Integer,Integer>left=new HashMap<>();
        HashMap<Integer,Integer>right=new HashMap<>();
        int result = 0;
        for(int num:nums){
            right.put(num,right.getOrDefault(num,0)+1);
        }
        for(int num:nums){
            right.put(num,right.get(num)-1);

            int l=left.getOrDefault(num*2,0);
            int r=right.getOrDefault(num*2,0);

           long add = (1L * l * r) % M; 
           result = (int)((result + add) % M);
            left.put(num,left.getOrDefault(num,0)+1);
        }
        return result;
    }
}