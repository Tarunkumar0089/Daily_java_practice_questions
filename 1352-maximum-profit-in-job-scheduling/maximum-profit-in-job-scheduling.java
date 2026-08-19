class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][]job=new int[n][3];

        for(int i=0;i<n;i++){
            job[i][0]=startTime[i];
            job[i][1]=endTime[i];
            job[i][2]=profit[i];
        }

        Arrays.sort(job,(a,b)->a[0]-b[0]);

        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return sol(0,job,dp);
    }

    public int sol(int i,int[][]job,int[]dp){
        if(i==job.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];

        int np=sol(i+1,job,dp);

        int next=find(job,job[i][1]);
        int p=job[i][2]+sol(next,job,dp);

        return dp[i]=Math.max(p,np);
    }

    public int find(int[][]job, int target){
         int lo=0;
         int hi=job.length-1;
         int ans=job.length;
         while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            
            if(job[mid][0]>=target){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
         }
         return ans;
    }
}