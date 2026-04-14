class Solution {
    public int largestRectangleArea(int[] heights) {
        int N= heights.length;
        if(N==1){
            return heights[0];
        }
        int [] nse = new int[heights.length];
        Stack<Integer> st= new Stack<>();
        for(int i=N-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=N-1;
            }
            else{
                nse[i]=st.peek()-1;
            }
            st.push(i);
        }
        st.clear();
        int [] pse = new int[N];
        for(int i=0;i<N;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=0;
            }
            else{
                pse[i]= st.peek()+1;
            }
            st.push(i);
        }

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            int wt = Math.max(1,nse[i]-pse[i]+1);
            
            int ht= heights[i];
            ans=Math.max(ans, wt*ht);
        }
        return Math.max(0,ans);
    }
}