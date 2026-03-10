class NumArray {
    int tree[];
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4*n];
        buildTree(nums,0,0,n-1);
    }
    public void buildTree(int nums[],int i,int left,int right){
        if(left==right){
            tree[i] = nums[right];
            return;
        }
        int mid = (left+right)/2;
        buildTree(nums,2*i+1,left,mid);
        buildTree(nums,2*i+2,mid+1,right);
        tree[i] = tree[2*i+1]+tree[2*i+2];
    }
    public void update(int index, int val) {
        updateTree(index,val,0,0,n-1);
    }
    public void updateTree(int idx,int val,int i,int l,int r){
        if(l==r){
            tree[i] = val;
            return;
        }
        int mid = (l+r)/2;
        if(idx<=mid){
            updateTree(idx,val,2*i+1,l,mid);
        }
        else{
            updateTree(idx,val,2*i+2,mid+1,r);
        }
        tree[i] = tree[2*i+1]+tree[2*i+2];
    }
    public int sumRange(int left, int right) {
        return query(0,left,right,0,n-1);
    }
    public int query(int i,int start,int end ,int l,int r){
        if(l>end || r<start){
            return 0;
        }
        if(l>=start && r<=end){
            return tree[i];
        }
        int mid = (l+r)/2;
        return query(2*i+1,start,end,l,mid)+query(2*i+2,start,end,mid+1,r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */