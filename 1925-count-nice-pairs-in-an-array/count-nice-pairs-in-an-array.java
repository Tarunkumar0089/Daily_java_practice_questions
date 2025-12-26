class Solution {
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        HashMap<Integer,Integer>map=new HashMap<>();

        int ans=0;
        for(int num:nums){
            int r=rev(num);
            int key=num-r;
            if (map.containsKey(key)) {
                ans = (ans + map.get(key)) % mod;
            }
             map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        return ans;
    }
    public int rev(int x) {
        int r = 0;
        while (x > 0) {
            r = r * 10 + (x % 10);
            x /= 10;
        }
        return r;
    }
}