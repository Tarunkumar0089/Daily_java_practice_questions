class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>list=new ArrayList<>();
        for(String q:queries){
            if(isPos(q,pattern)){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
    public boolean isPos(String q,String pattern){
        int i=0;
        int j=0;
        while(i<q.length()){
            if(j<pattern.length()&&q.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                char ch=q.charAt(i);
                if(ch>='A' && ch<='Z'){
                    return false;
                }
                i++;
            }
        }
        return j==pattern.length();
    }
}