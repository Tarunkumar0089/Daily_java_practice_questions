class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Solve(candidates,target,0,ans,ll);
        return ans;

    }
    public static void Solve(int [] candidates, int target, int idx, List<List<Integer>> ans,
    List<Integer> ll){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(idx>= candidates.length){
            return;
        }
        if(target>=candidates[idx]){
            ll.add(candidates[idx]);
            Solve(candidates, target-candidates[idx],idx+1,ans,ll);
            ll.remove(ll.size()-1);
        }
        while(idx+1<candidates.length && candidates[idx]==candidates[idx+1]) idx++;
        
        Solve(candidates,target,idx+1,ans,ll);
    }
}