class Solution {
    public boolean hasAllCodes(String s, int k) {
        int code=(int)Math.pow(2,k);
        HashSet<String>set=new HashSet<>();
        for(int i=k;i<=s.length();i++){
            String sub=s.substring(i-k,i);
            if(!set.contains(sub)){
                set.add(sub);
            }
        }
        return code==set.size();
    }
}