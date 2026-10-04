class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // sort array first
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        Map<List<Integer>,List<Integer>> map = new HashMap<>();

        // 2 pointers init is 0 & 1, for each nums[i] and nums[j], we loop thru the rest of the array and find nums[k]
        // if found, add to res list sorted as a value (List<Integer>)
        // for new checks, need to sort it once found and then compare to what's in the value of map to prevent dupes.
        // then we shift our j pointer once and start loop again; same for shifting i when time comes

        // k becomes our target; and we return the ijk(target) compared to twosum2 prob

        // int i = 0;
        // int j = nums.length - 1;
        
        int j = 1;
        int k = nums.length - 2;


        for (int i = 0; i < nums.length - 1; i++){
            while (j < k) {

                int compl = 0 - nums[j] - nums[k];

                List<Integer> list = new ArrayList<>();
                if (compl < 0 - nums[j] - nums[k]) {
                    j++;
                } else if (compl > 0 - nums[j] - nums[k]) {
                    k--;
                }
                else {
                    list.add(i);
                    list.add(j);
                    list.add(k);
                    List<Integer> valList = list;

                    // sort array to add sorted array as key and unsorted as value and insert them into map
                    list.sort((a, b) -> list.get(b) - list.get(a));

                    // compare current List and key List 
                    // if not present, add
                    // if present, update value of key list
                    
                    // map.getOrDefault(list, map.put(list, valList));


                    if (map.containsKey(list)) {
                        List<Integer> keyList = map.get(list);
                        keyList.add(valList);
                        map.put(list, keyList);
                    } else {
                        List<Integer> keyList = new ArrayList<>();
                        keyList.add(valList);
                        map.put(list, keyList);
                    } 
                }
            }

        }

        return map.values();
    
        // while (i < j) {
        //     List<Integer> list = new ArrayList<>();
        //     if (nums[k] < 0 - nums[i] - nums[j]) {
        //         i++;
        //     } else if (nums[k] > 0 - nums[i] - nums[j]) {
        //         j--;
        //     }
        //     else {
        //         list.add(i);
        //         list.add(j);
        //         list.add(k);
        //         List<Integer> valList = list;

        //         // sort array to add sorted array as key and unsorted as value and insert them into map
        //         list.sort((a, b) -> list.get(b) - list.get(a));

        //         // compare current List and key List 
        //         // if not present, add
        //         // if present, update value of key list
        //         map.getOrDefault(list, map.put(list, valList));
        //     }
        // }


    

    }
}
