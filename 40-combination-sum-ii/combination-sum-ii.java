class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {  
        Arrays.sort(arr);
     List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        sol(arr, target,list, 0,ans);
        return ans;
    }
    public static void sol(int[] arr,int target,List<Integer>list,int idx,List<List<Integer>>ans){
    if(target==0){
        ans.add(new ArrayList<>(list));
        return;
    }
    for(int i=idx;i<arr.length;i++){
        if (i > idx && arr[i] == arr[i - 1]) continue;
        if (arr[i] > target) break; 
        if(target>=arr[i]){
            list.add(arr[i]);
            sol(arr,target-arr[i],list,i+1,ans);
            list.remove(list.size()-1);
        }
    }
}
}