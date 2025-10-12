class Solution {
    public List<String> letterCasePermutation(String s) {
        ArrayList<String> list=new ArrayList<>();
        char[] ch=s.toCharArray();
        sol(ch,0,list);
        return list;
    }
    public void sol(char[] arr,int idx,ArrayList<String>list){
        if(idx==arr.length){
            list.add(new String(arr));
            return;
        }
        char c=arr[idx];
        if(Character.isLetter(c)){
            arr[idx]=Character.toLowerCase(c);
            sol(arr,idx+1,list);


            arr[idx]=Character.toUpperCase(c);
            sol(arr,idx+1,list);

        }
        else{
            sol(arr,idx+1,list);
        }
    }
}