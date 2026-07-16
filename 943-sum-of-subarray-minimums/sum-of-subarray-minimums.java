class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] pref=new int[arr.length];
        int[]suff=new int[arr.length];

        Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            while(!st.isEmpty()&&arr[st.peek()]>=num){
                st.pop();
            }
            if(st.isEmpty()){
                pref[i]=-1;
            }
            else{
                pref[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();

        for(int i=arr.length-1;i>=0;i--){
            int num=arr[i];
            while(!st.isEmpty()&&arr[st.peek()]>num){
                st.pop();
            }
            if(st.isEmpty()){
                suff[i]=arr.length;
            }
            else{
                suff[i]=st.peek();
            }
            st.push(i);
        }
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum = (sum+ ((long)arr[i]*(long)(i-pref[i]) * (long)(suff[i]-i))%1000000007)%1000000007;
           // sum+=((long)((i-pref[i])*(long)(suff[i]-i))*(long)arr[i])%1000000007;
        }

        return (int)(sum%1000000007);


    }
}