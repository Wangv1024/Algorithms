/**
 * Created by weihengwang on 7/23/17.
 */
public class _307RangeSumQueryMutable {
    int[] nums;
    int[] accum;
    public _307RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        accum = new int[nums.length + 1];
        for(int i = 0; i < this.nums.length; i ++){
            initial(i, nums[i]);
        }
    }

    private void initial(int idx, int val){
        idx ++;
        while(idx < accum.length){
            accum[idx] += val;
            idx += (idx & -idx);
        }
    }

    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;

        // 	i++;   // Bugs !!
        initial(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    private int getSum(int i){
        i ++;
        int sum = 0;
        while(i > 0){
            sum += accum[i];
            i -= (i & -i);
        }
        return sum;
    }

    // public class NumArray {
//     int[] tree;
// 	int n;
//     public NumArray(int[] nums) {
//     	n = nums.length;
//         int n2 = n << 1;
//     	tree = new int[n2];

//     	for(int i = n, j = 0; i < n2; ++ i, ++ j ){
//     		tree[i] = nums[j];
//     	}
//     	for(int i = n - 1; i > 0; -- i){
//     		tree[i] = tree[i << 1] + tree[(i << 1) + 1];
//     	}
//     }
//     public void update(int i, int val) {
//     	int pos = i + n;
//     	tree[pos] = val;

//     	int left = pos % 2 == 0 ? pos : pos - 1;
//     	int right = pos % 2 != 0 ? pos : pos + 1;
//     	pos = pos >> 1;
//     	while(pos > 0){
//     		tree[pos] = tree[left] + tree[right];

// 	    	left = pos % 2 == 0 ? pos : pos - 1;
// 	    	right = pos % 2 != 0 ? pos : pos + 1;
// 	    	pos = pos >> 1;
//     	}
//     }
//     public int sumRange(int i, int j) {
//     	int l = n + i, r = n + j;  // bugs:  int l = i, r = j;
//     	int sum = 0;
//     	while(l <= r){
//     		if(l % 2 != 0)
//     			sum += tree[l ++];
//     		if(r % 2 == 0)
//     			sum += tree[r --];
//     		l = l >> 1;
//     		r = r >> 1;
//     	}
//     	return sum;
//     }
// }
}
