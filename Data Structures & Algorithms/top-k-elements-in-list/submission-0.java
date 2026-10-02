class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 1. get keys in a list
        List<Integer> keyList = new ArrayList<>(map.keySet());

        // sort keys by their frequency in descending order
        keyList.sort((a, b) -> map.get(b) - map.get(a));

        // loop thru key list till we get k most freq element and add to the res array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keyList.get(i);
        }

        return res;
    }
}