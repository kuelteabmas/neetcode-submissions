class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        // int j = 1; 
        // int k = nums.length-1;

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length;i++) {
            // eliminate dupes if nums[i] and nums[i+1]
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i+1; // have to set next element after initial pointer (i) to maintain the 2 pointer algo and logic -- not use int j = 1;
            int k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) { // decrease sum -> shift right pointer -> k
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++; //
                    // 
                    // k--;
                    while(nums[j] == nums[j-1] && j < k) {
                        j++;
                    }

                } 
            }
        }

        return res;
    }
}
