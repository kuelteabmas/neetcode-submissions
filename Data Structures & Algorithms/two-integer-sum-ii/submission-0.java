class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
        // for (int i =0; i < nums.length; i++) {
            if(nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                return new int[]{l+1,r+1};
            }
        }
        throw new IllegalArgumentException("no match");        
    }
}
