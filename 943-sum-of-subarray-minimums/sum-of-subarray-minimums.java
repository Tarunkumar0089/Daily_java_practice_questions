class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1000000007;
        int left[] =new int[n];
        int right[] =new int[n];

        Stack<int[]>st1=new Stack<>();
        Stack<int[]>st2=new Stack<>();

        for(int i=0;i<n;i++){
           while(!st1.isEmpty()&& arr[i]<=st1.peek()[0]){
            st1.pop();
           }
           left[i]=st1.isEmpty()?-1:st1.peek()[1];
           st1.push(new int[]{arr[i],i});
        }

        for(int i=n-1;i>=0;i--){
           while(!st2.isEmpty()&& arr[i]<st2.peek()[0]){
            st2.pop();
           }
           right[i]=st2.isEmpty()?n:st2.peek()[1];
           st2.push(new int[]{arr[i],i});
        } 

        long sum=0;
        for(int i=0;i<n;i++){
            long l=i-left[i];
            long r=right[i]-i;
            long curr=arr[i]*(l*r);
            sum+=curr;
        }
        return (int)(sum%mod);
    }
}