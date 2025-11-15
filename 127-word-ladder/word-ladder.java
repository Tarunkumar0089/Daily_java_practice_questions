class Solution {

     class Pair{
        String first;
        int second;
        Pair(String f,int s){
            this.first=f;
            this.second=s;
        }
     }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        HashSet<String>set=new HashSet<>();
        int l=wordList.size();
        for(int i=0;i<l;i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int step=q.peek().second;

            q.remove();
            if(word.equals(endWord)==true) return step;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replace[]=word.toCharArray();
                    replace[i]=ch;
                    String replace_word=new String(replace);
                    if(set.contains(replace_word)){
                        set.remove(replace_word);
                        q.add(new Pair(replace_word,step+1));
                    }
                }
            }
        }
        return 0;
    }
}