class Solution {
    public int[] countMentions(int n, List<List<String>> events) {
        int [] ans= new int[n];
        Collections.sort(events,(a,b)->{
            int t1= Integer.parseInt(a.get(1));
            int t2= Integer.parseInt(b.get(1));
            if(t1!=t2){
            return Integer.compare(t1,t2);
            }

            if(a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")) return -1;
            if(a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")) return 1;
            return 0;
        });

        int[] map= new int[n];
        for(List<String> ll:events){
            if(ll.get(0).equals("OFFLINE")){
                int id= Integer.parseInt(ll.get(2));
                int time=Integer.parseInt(ll.get(1));
                map[id]=time+60;
            }
            else{
                if(ll.get(2).equals("ALL")){
                    for(int i=0;i<n;i++){
                        ans[i]++;
                    }
                }
                else if(ll.get(2).charAt(0)=='i'){
                    String [] ids= ll.get(2).split(" ");
                    for(String format:ids){
                       int id = Integer.parseInt(format.substring(2));
                       ans[id]++;
                    }
                }
                else{
                    int currTime= Integer.parseInt(ll.get(1));
                    for(int i=0;i<n;i++){
                        if(map[i]<=currTime) ans[i]++;
                    }
                }
            }
        }
        return ans;

    }
}