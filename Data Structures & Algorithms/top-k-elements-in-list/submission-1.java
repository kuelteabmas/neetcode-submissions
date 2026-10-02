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

        // **** my version *** not working but similar thought process to above solution
        
        // Map<Integer, Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (map.containsKey(nums[i])) {
        //         map.put(nums[i], 1);
        //     } else {
        //         int currVal = map.get(nums[i]);
        //         map.put(nums[i], currVal++);
        //     }
        // }
        // // find most freq elements

        // // this sort the map abuy sorting the Collections.values()
        // Collection<Integer> mapValues = map.values();
        // Integer[] mapValuesArr = mapValues.toArray();
        // Arrays.sort(mapValuesArr);

        // // fetching the k most freq elements
        // int[] res = new int[]{k};

        // // 1. get keys in a list/array
        // Set<Integer> keySet = map.keySet();
        // int[] keySetArr = keySet.toArray();

        // // loop thru key array till we get k most freq element and add the keys to the res array
        // List<Integer> resList = new ArrayList();

        // for (int i = 0; i < k; i++) {
        //     resList.add(keySetArr[i]);
        // }

        // return resList.toArray();

    }
}