class Solution {
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        int [] nsi = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsi[i]=arr.length;
            }
            else{
                nsi[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        int [] psi = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                psi[i]=-1;
            }
            else{
                psi[i]=st.peek();
            }
            st.push(i);
        }

        long sum=0;
        for(int i=0;i<arr.length;i++){
             int next = nsi[i];
             int prev = psi[i];
             sum+= ((long)arr[i]*((next-i)*(i-prev)));
        }
        return (int)(sum%1000000007);
    }
}