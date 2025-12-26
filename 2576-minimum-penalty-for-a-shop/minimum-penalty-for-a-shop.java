class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int p=0;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y') p++;
        }

        int minP=p;
        int bestHour=0;

        for(int j=1;j<=n;j++){
            if(customers.charAt(j-1)=='Y'){
                p--;
            }
            else{
                p++;
            }
            if(p<minP){
                minP=p;
                bestHour=j;
            }
        }
        return bestHour;
    }
}