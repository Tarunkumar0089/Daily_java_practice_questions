class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> banned= new HashSet<>();
        for(String s: bannedWords){
            banned.add(s);
        }
        int c=0;
        for(String s: message){
            if(banned.contains(s)){
                c++;
                if(c==2) return true;
            }
        }
        return c>=2;
    }
}