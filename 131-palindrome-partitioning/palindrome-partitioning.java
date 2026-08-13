class Solution {
    public List<List<String>> partition(String str) {
       List<String>list=new ArrayList<>();
        List<List<String>>ans=new ArrayList<>();
        sol(str,list,ans);
        return ans;
    }
   public static void sol(String str,List<String>list,List<List<String>>ans){
        if(str.length()==0){
           ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<=str.length();i++) {
            String temp = str.substring(0, i);
            if (ispalindrom(temp)) {
                list.add(temp);
                sol(str.substring(i), list,ans);
                list.remove(list.size()-1);
            }
        }

    }
    public static boolean ispalindrom(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}