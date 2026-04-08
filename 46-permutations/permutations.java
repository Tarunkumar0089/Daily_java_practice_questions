class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>>list=new ArrayList<>();
       List<Integer>ans=new ArrayList<>();
       boolean check[]=new boolean[nums.length];
       sol(nums,list,ans,check);
       return list;
    }
    public void sol(int[] nums,List<List<Integer>>list,List<Integer>ans,boolean[]check){
        if(ans.size()==nums.length){
               list.add(new ArrayList<>(ans));
                return;
            }
        for(int i=0;i<nums.length;i++){
            if(check[i]==false){
            ans.add(nums[i]);
            check[i]=true;
            sol(nums,list,ans,check);
            ans.remove(ans.size()-1);
            check[i]=false;
            }
        }
    }
    }
