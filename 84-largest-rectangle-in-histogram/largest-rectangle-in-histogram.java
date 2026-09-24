class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[]pse=new int[n];
        int[]nse=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);

        }
        st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }else{
                nse[i]=st.peek();
            }
            st.push(i);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int l=pse[i];
            int r=nse[i];
            int h=heights[i];
            int w=r-l-1;
            ans=Math.max(ans,h*w);
        }
        return ans;


    }
}