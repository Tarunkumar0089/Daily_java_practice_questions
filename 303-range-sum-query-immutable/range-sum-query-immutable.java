class NumArray {
    int[] segmentTree;
    int[] arr;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        if (n == 0) return;
        segmentTree = new int[n*4];
        arr = nums;
        build(0, 0, n - 1);
    }
    public void build(int i, int left, int right){
        if(left == right){
            segmentTree[i] = arr[left];
            return;
        }
        int mid = (left + right) / 2;
        build(2*i+1, left, mid);
        build(2*i+2, mid+1, right);
        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    public int querySum(int i, int left, int right, int start, int end){
        if(start > right || end < left) return 0;

        if(left <= start && end <= right) 
            return segmentTree[i];

        int mid = (start + end) / 2;

        return querySum(2*i+1, left, right, start, mid) +
               querySum(2*i+2, left, right, mid+1, end);
    }
    
    public int sumRange(int left, int right) {
        if (n == 0) return 0;   
        return querySum(0, left, right, 0, n - 1);
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */