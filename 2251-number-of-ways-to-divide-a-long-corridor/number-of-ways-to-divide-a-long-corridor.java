class Solution {
    int m=1000000007;
    public int numberOfWays(String corridor) {
        int n=corridor.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S'){
                cnt++;
            }
        }
        if(cnt==0 || cnt%2!=0) {
            return 0;
        }
        
        long ans=1;
        int i=0;
        cnt=0;
        boolean flag=false;
        int p=0;
        while(i<n){
            if(corridor.charAt(i)=='S'){
                 cnt++;
                if(cnt % 2 == 0){
                    flag = true;
                } else if(cnt > 2){
                    ans = (ans * (p + 1)) % m;
                    cnt = 1; flag = false;
                    p = 0;
                }
            }
            else if(flag){
                p++;
            }
            i++;
        }
        return (int) ans;
    }
}