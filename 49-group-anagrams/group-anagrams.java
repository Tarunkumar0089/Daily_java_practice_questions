class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> list=new ArrayList<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String newstr=new String(ch);
            if(!map.containsKey(newstr)){
                map.put(newstr,new ArrayList<>());
            }
                map.get(newstr).add(str);
        }
        // for(int i=0;i<map.size();i++){
        //     list.add(map.get(i));
        //     System.out.print(map.get(i));
        // }
        // return list;
        return new ArrayList<>(map.values());
    }
}